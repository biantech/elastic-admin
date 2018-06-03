package com.biantech.elastic.common.util;

import com.biantech.elastic.admin.entity.ElasticMenu;
import java.util.Comparator;

/**
 * Created by Mr.biantech on 2017/8/8.
 * Time:9:49
 * ProjectName:elastic-admin
 * <p>升序</p>
 */
public class MenuComparator implements Comparator<ElasticMenu> {
    @Override
    public int compare(ElasticMenu o1, ElasticMenu o2) {
        if (o1 == null && o2 == null){
            return 0;
        }
        if (o1 != null && o2 == null){
            return -1;
        }
        if (o1 == null && o2 != null){
            return 1;
        }
        if (o1.getSort().compareTo(o2.getSort())>0){
            return 1;
        }
        return -1;
    }
}
