package com.ww.mail.domain.db.mapper;

import com.ww.mail.domain.db.entities.TAccessToken;
import com.ww.mail.domain.db.entities.TAccessTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAccessTokenMapper {
    int countByExample(TAccessTokenExample example);

    int deleteByExample(TAccessTokenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TAccessToken record);

    int insertSelective(TAccessToken record);

    List<TAccessToken> selectByExample(TAccessTokenExample example);

    TAccessToken selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TAccessToken record, @Param("example") TAccessTokenExample example);

    int updateByExample(@Param("record") TAccessToken record, @Param("example") TAccessTokenExample example);

    int updateByPrimaryKeySelective(TAccessToken record);

    int updateByPrimaryKey(TAccessToken record);
}