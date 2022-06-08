package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.domain.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    @Select("select distinct m.perms from user_role ur \n" +
            "   left join role r on ur.role_id=r.id\n" +
            "   left join role_menu rm on ur.role_id=rm.role_id\n" +
            "   left join menu m on m.id = rm.menu_id\n" +
            " where user_id=#{id};" )
    List<String> selectPermsByUserId(Long id);
}
