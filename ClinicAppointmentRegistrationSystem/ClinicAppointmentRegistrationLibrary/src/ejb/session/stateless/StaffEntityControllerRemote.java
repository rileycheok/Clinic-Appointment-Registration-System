/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.StaffEntity;
import java.util.List;
import javax.ejb.Remote;
import util.exception.InvalidLoginException;
import util.exception.StaffNotFoundException;

/**
 *
 * @author Shi Yun
 */
@Remote
public interface StaffEntityControllerRemote {

    public StaffEntity retrieveStaffByUsername(String username) throws StaffNotFoundException;
            
    public StaffEntity staffLogin(String username, String password) throws InvalidLoginException;
    
    public List<StaffEntity> retrieveAllStaffs();
    
    public StaffEntity retrieveStaffByStaffId(Long staffId) throws StaffNotFoundException;
    
    public void updateStaff(StaffEntity staffEntity);
    
    public void deleteStaff(Long staffId) throws StaffNotFoundException;
    
    public StaffEntity createNewStaff(StaffEntity staffEntity);
    
}
