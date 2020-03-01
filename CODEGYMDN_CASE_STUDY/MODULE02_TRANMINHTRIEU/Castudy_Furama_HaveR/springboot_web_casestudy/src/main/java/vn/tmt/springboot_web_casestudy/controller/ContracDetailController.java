package vn.tmt.springboot_web_casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.tmt.springboot_web_casestudy.entity.Accompanied;
import vn.tmt.springboot_web_casestudy.entity.Contract;
import vn.tmt.springboot_web_casestudy.entity.ContractDetail;
import vn.tmt.springboot_web_casestudy.repository.AccompaniedRepository;
import vn.tmt.springboot_web_casestudy.repository.ContractDetailRepository;
import vn.tmt.springboot_web_casestudy.repository.ContractRepository;

@Controller
public class ContracDetailController {

    @Autowired
    ContractDetailRepository contractDetailRepository;

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    AccompaniedRepository accompaniedRepository;

    @ModelAttribute("contracts")
    public Iterable<Contract> getAllContract(){
        return contractRepository.findAll();
    }

    @ModelAttribute("accompanieds")
    public Iterable<Accompanied> getAllAccompanied(){
        return accompaniedRepository.findAll();
    }

    @GetMapping("admin/contractDetail")
    public String createContractDetail(Model model){
        model.addAttribute("contractDetail",new ContractDetail());
        return "contractDetail/create";
    }

    @PostMapping("admin/contractDetail/create")
    public ModelAndView createContractDetail(@ModelAttribute(name = "contractDetail") ContractDetail contractDetail){
        contractDetailRepository.save(contractDetail);
        ModelAndView modelAndView = new ModelAndView("contractDetail/create");
        modelAndView.addObject("contractDetail", new ContractDetail());
        modelAndView.addObject("message", "New contract detail created successfully");
        return modelAndView;
    }
}
