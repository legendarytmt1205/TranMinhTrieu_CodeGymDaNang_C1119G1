package vn.tmt.springboot_web_casestudy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tmt.springboot_web_casestudy.entity.ContractDetail;
import vn.tmt.springboot_web_casestudy.repository.ContractDetailRepository;
import vn.tmt.springboot_web_casestudy.service.ContractDetailService;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {

    @Autowired
    ContractDetailRepository contractDetailRepository;

    @Override
    public void saveContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
