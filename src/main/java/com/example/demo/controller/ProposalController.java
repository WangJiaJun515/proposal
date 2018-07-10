package com.example.demo.controller;

import com.example.demo.entity.Proposal;
import com.example.demo.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ProposalController {
    @Autowired
    private ProposalService proposalService;
     private List<Proposal> list2 = new ArrayList<Proposal>();

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(HttpServletRequest request,@ModelAttribute("member") Proposal proposal,Model model) {
        List<Proposal> list = proposalService.getAllProposal();
        request.setAttribute("proposals", list);
            return "search.html";

    }

    @RequestMapping(value = "/write",method = RequestMethod.GET)
    public String write(Model model){
       model.addAttribute("proposal",new Proposal());
        return "write.html";
    }
    @RequestMapping(value = "/main1", method = RequestMethod.GET)
    public String insert(@ModelAttribute("proposal") Proposal proposal, Model model){
        proposalService.insert(proposal);
        return "main.html";
    }


    @RequestMapping(value = "/prodetail", method = RequestMethod.GET)
    public String getProposal(@RequestParam("p_id") int p_id, Model model, HttpServletRequest request) {
        model.addAttribute("proposal",new Proposal());
        List<Proposal> list = proposalService.getAllProposal();
       // request.setAttribute("comlist", list);

        for (Proposal a : list) {
            if (a.getId() == p_id) {
                list2.add(a);
                request.setAttribute("proposalOne", list2);
                return "onePro.html";
            }
        }
        return "search.html";
    }

    @RequestMapping(value = "/search1", method = RequestMethod.GET)
    public String search1(@ModelAttribute("proposal") Proposal proposal, Model model, HttpServletRequest request) {
        Proposal pro = list2.get(list2.size()-1);
        //System.out.println(list2);
        proposalService.update(pro.getId(),proposal.getComment());
        list2.clear();
        List<Proposal> list = proposalService.getAllProposal();
        request.setAttribute("proposals", list);
        return "search.html";

    }

}
