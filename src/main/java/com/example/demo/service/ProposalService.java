package com.example.demo.service;

import com.example.demo.entity.Proposal;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface ProposalService {

    List<Proposal> getAllProposal();

    boolean insert(Proposal proposal);
    boolean update(@Param("id") Integer id,
                   @Param("comment") String comment);
}