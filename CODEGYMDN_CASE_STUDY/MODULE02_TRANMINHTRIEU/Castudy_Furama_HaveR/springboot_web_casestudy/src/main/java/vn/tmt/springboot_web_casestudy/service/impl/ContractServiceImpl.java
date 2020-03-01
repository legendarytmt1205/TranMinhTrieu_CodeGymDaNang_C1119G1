package vn.tmt.springboot_web_casestudy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tmt.springboot_web_casestudy.entity.Contract;
import vn.tmt.springboot_web_casestudy.repository.ContractRepository;
import vn.tmt.springboot_web_casestudy.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Override
    public void saveContract(Contract contract) {
        contractRepository.save(contract);
    }
}