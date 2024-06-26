package com.example.mabank.web;

import com.example.mabank.entities.Compte;
import com.example.mabank.entities.Operation;
import com.example.mabank.service.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BanqueController {
    @Autowired
    private IBanqueMetier banqueMetier;

    @RequestMapping("/operations")
    public String index() {
        return "comptes";
    }

    @RequestMapping("/consulterCompte")
    public String consulter(Model model, @RequestParam String codeCompte, @RequestParam(required = false) String error,@RequestParam(name="page",defaultValue = "0") int page,@RequestParam(name="size",defaultValue = "5")int size ) {
        model.addAttribute("codeCompte", codeCompte);
        if (error != null) {
            model.addAttribute("error", error);
        }
        try {
            Compte cp = banqueMetier.consulterCompte(codeCompte);
            Page<Operation> pageOperations = banqueMetier.listOperation(codeCompte, page, size);
            model.addAttribute("listOperations", pageOperations.getContent());
            int[]pages=new int[pageOperations.getTotalPages()];
            model.addAttribute("pages",pages);
            model.addAttribute("compte", cp);
            model.addAttribute("pageOperations", pageOperations);
        } catch (Exception e) {
            model.addAttribute("exception", e);
        }
        return "comptes";
    }

    @RequestMapping(value = "/saveOperation", method = RequestMethod.POST)
    public String saveOperation(Model model, String typeOperation, String codeCompte, double montant, String codeCompte2) {
        try {
            if (typeOperation.equals("VERS")) {
                banqueMetier.verser(codeCompte, montant);
            } else if (typeOperation.equals("RETR")) {
                banqueMetier.retirer(codeCompte, montant);
            } else if (typeOperation.equals("VIR")) {
                banqueMetier.virement(codeCompte, codeCompte2, montant);
            }
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/consulterCompte?codeCompte=" + codeCompte + "&error=" + e.getMessage();
        }
        return "redirect:/consulterCompte?codeCompte=" + codeCompte;
    }

}
