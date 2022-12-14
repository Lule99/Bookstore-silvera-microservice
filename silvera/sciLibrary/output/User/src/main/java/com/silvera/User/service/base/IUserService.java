/**
    THIS IS GENERATED CODE AND SHOULD NOT BE CHANGED MANUALLY!!!

    Generated by: silvera
    Date: 2022-05-07 18:49:21
*/

package com.silvera.User.service.base;

import com.silvera.User.domain.model.*;


public interface IUserService {

    // Auto-generated CRUD methods
    
    
    
    public User createUser(User user);
    
    
    public User updateUser(java.lang.String id, User userUpdate);
    
    
    public User readUser(java.lang.String id);
    
    
    public void deleteUser(java.lang.String id);
    
    


    
     
    
    public User register(User user) ;
    
     
    
    public User login(LoginDto loginDto) ;
    
     
    
    public void logout(java.lang.String username) ;
    
     
    
    public java.util.List<User> getAllUsers() ;
    
     
    
    public java.lang.Boolean isLoggedIn(java.lang.String username) ;
    
     
    
    public java.lang.String getName(java.lang.String username) ;
    

}