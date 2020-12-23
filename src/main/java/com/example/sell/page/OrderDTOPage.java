package com.example.sell.page;

import com.example.sell.dto.OrderDTO;
import lombok.Data;

import java.util.List;

/**
 * @author zrl
 * @date 2020-12-19 17:44
 */
@Data
public class OrderDTOPage {
    Integer totalPage;
    Integer pageSize;
    List<OrderDTO> allData;
    Integer index;

    public OrderDTOPage(List<OrderDTO> allData, Integer pageSize, Integer index) {
        this.pageSize = pageSize;
        this.allData = allData;
        allData.sort((o1, o2)->o2.getCreateTime().compareTo(o1.getCreateTime()));  //从大到小排序
        this.index = index;
        totalPage = allData.size()/pageSize;
        if (allData.size()%pageSize!=0) {
            totalPage += 1;
        }
        System.out.println(totalPage);
    }

    public List<OrderDTO> getDataByIndex() {
        if (index*pageSize>allData.size()) {
            return allData.subList((index-1)*pageSize,allData.size());
        }
        return allData.subList((index-1)*pageSize,index*pageSize);
    }
}
