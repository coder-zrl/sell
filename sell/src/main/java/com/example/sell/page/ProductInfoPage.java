package com.example.sell.page;

import com.example.sell.dataobject.ProductInfo;
import com.example.sell.dto.OrderDTO;
import lombok.Data;

import java.util.List;

/**
 * @author zrl
 * @date 2020-12-20 17:21
 */
@Data
public class ProductInfoPage {
    Integer totalPage;
    Integer pageSize;
    List<ProductInfo> allData;
    Integer index;

    public ProductInfoPage(List<ProductInfo> allData, Integer pageSize, Integer index) {
        this.pageSize = pageSize;
        this.allData = allData;
        allData.sort((o1, o2)->o1.getProductId().compareTo(o2.getProductId()));  //从大到小排序
        this.index = index;
        totalPage = allData.size()/pageSize;
        if (allData.size()%pageSize!=0) {
            totalPage += 1;
        }
        System.out.println(totalPage);
    }

    public List<ProductInfo> getDataByIndex() {
        if (index*pageSize>allData.size()) {
            return allData.subList((index-1)*pageSize,allData.size());
        }
        return allData.subList((index-1)*pageSize,index*pageSize);
    }
}
