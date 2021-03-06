package com.yp.foodmall.food.mapper;

import com.yp.foodmall.common.entity.Category;
import com.yp.foodmall.common.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import sun.misc.Cache;

import java.util.List;

@Mapper
public interface IComMapper {
    //commodity
    public int insertCom(Commodity com);
    public int deleteCom(int commodityNumber);
    public int updateCom(Commodity com);
    public Commodity selectOneByNUmber(int comId);
    public List<Commodity> selectList(Commodity com);
    public List<Commodity> selectAllCom();

    //category
    public int insertCategory(Category category);
    public int deleteCategory(int categoryId);
    public int updateCategory(Category category);


}
