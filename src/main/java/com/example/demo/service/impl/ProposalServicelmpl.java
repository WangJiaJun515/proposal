package com.example.demo.service.impl;

import com.example.demo.dao.ProposalDao;
import com.example.demo.entity.Proposal;
import com.example.demo.service.ProposalService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;

import java.util.List;


@Service
public class ProposalServicelmpl implements ProposalService {

    @Autowired
    private ProposalDao proposalDao;

    public List<Proposal> getAllProposal() {
        return proposalDao.getAllProposal();
    }


    public boolean insert(Proposal proposal) {
        if (null == proposal) {
            return false;
        }
        // do something...
        proposalDao.insert(proposal);
        return true;
    }

   public boolean update(@Param("id") Integer id,
                   @Param("comment") String comment) {
        if (null == comment) {
            return false;
        }
        proposalDao.update(id, comment);
        return true;

    }

}