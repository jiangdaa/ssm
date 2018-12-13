package com.ssm.utils;


import com.ssm.pojo.SsmMenu;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtils {


    public static List<SsmMenu> getPermissionByUser(String username) {
        return null;

    }

    public static List<SsmMenu> disposeMenu(Integer id, List<SsmMenu> menu) {
        List<SsmMenu> childList = new ArrayList<>();
        for (SsmMenu ssmMenu : menu) {
            // 如果
            if (ssmMenu.getParent_id().equals(id)) {
                childList.add(ssmMenu);
            }
        }

        for (SsmMenu ssmMenu : childList) {
            ssmMenu.setChildMenus(PermissionUtils.disposeMenu(ssmMenu.getMenu_id(), menu));
        }
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }


}
