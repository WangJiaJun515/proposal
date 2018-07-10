package com.example.demo.dao;

import com.example.demo.entity.Proposal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ProposalDao {
    @Select(value = "SELECT * FROM proposal")
    List<Proposal> getAllProposal();
    @Insert(value = "INSERT INTO proposal(proposal.`writer`,proposal.`topic`,proposal.content,proposal.comment)\n" +
            "VALUE(#{writer},#{topic},#{content},#{comment})")
    int insert(Proposal Proposal);
    @Update(value = "UPDATE proposal SET proposal.comment = #{comment} WHERE proposal.id = #{id}")
    int update(
            @Param("id") Integer id,
            @Param("comment") String comment);
}
