package com.fatec.contracts.controller;

import com.fatec.contracts.controller.dto.request.ContractDto;
import com.fatec.contracts.service.ContractService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
@RequestMapping(path = "/contracts")
public class ContractController {

    private ContractService contractService;

    @GetMapping(path = "/form")
    public ModelAndView newContract(ContractDto contractDto) {
        return new ModelAndView("new-contract");
    }

    @PostMapping(path = "/new")
    public String save(@Valid ContractDto contractDto, BindingResult result) {
        if(result.hasErrors()) {
            return "new-contract";
        }
        contractService.save(contractDto);
        return "redirect:/";
    }

}
