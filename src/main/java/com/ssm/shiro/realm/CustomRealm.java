package com.ssm.shiro.realm;

import com.ssm.dao.MemberDao;
import com.ssm.dao.MenuDao;
import com.ssm.dao.PermissionDao;
import com.ssm.pojo.SsmMenu;
import com.ssm.pojo.SsmPermission;
import com.ssm.vo.MemberVo;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private MenuDao menuDao;

    /**
     * 授权
     *
     * @param principalCollection 权限分配
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        // 查询当前用户角色
        String username = (String) principalCollection.getPrimaryPrincipal();
        if (null != username) {
            MemberVo memberVo = new MemberVo();
            memberVo.setUsername(username);
            // 角色id
            String roleIds = memberDao.getRoleIdsByUsername(memberVo);
            // 根据角色id查询角色名称
            List<SsmPermission> permissionsByRoleIds = permissionDao.findPermissionsByRoleIds(roleIds);

            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            StringBuilder permissionIds = new StringBuilder();
            for (SsmPermission ssmPermission : permissionsByRoleIds) {
                info.addRole(ssmPermission.getPermissions_name());
                permissionIds.append(ssmPermission.getPermissions()).append(",");
            }
            // 根据角色查询对应的功能
            String disStr = permissionIds.substring(0, permissionIds.lastIndexOf(","));
            List<SsmMenu> permissions = menuDao.findActionByPermissionIds(disStr, 3);
            List<String> permissionList = new ArrayList<>();
            for (SsmMenu ssmMenu : permissions) {
                permissionList.add(ssmMenu.getCode());
                System.out.println(ssmMenu.getCode());
            }
            info.addStringPermissions(permissionList);
            // 缓存对当前用户的菜单信息
            return info;
        }

        return null;
    }

    /**
     * 认证账号
     *
     * @param authenticationToken 账号信息
     * @return SimpleAuthenticationInfo
     * @throws AuthenticationException 账号异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        if ("".equals(username)) {
            return null;
        }
        return new SimpleAuthenticationInfo(username, password, this.getName());
    }
}
