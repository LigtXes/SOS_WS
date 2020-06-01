
/**
 * UPMBankWSSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package es.upm.fi.sos.upmbank;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.Map;

import org.apache.axis2.AxisFault;
    /**
     *  UPMBankWSSkeleton java skeleton for the axisService
     */
    public class UPMBankWSSkeleton{
    	
    	//Use to know the client 
    	private static int instanceCounter = 0;
    	private int instance;
    
    	//Use to know info about super user
    	private String name; 
    	private static String superUserPSW = "admin";
    	
    	private Map<Integer, es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub> users = 
    			new HashMap<>();
    	
        /**
         * Auto generated method signature
         * 
                                     * @param addBankAcc 
             * @return addBankAccResponse 
         */
        
                 public es.upm.fi.sos.upmbank.AddBankAccResponse addBankAcc
                  (
                  es.upm.fi.sos.upmbank.AddBankAcc addBankAcc
                  )
            {
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#addBankAcc");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param closeBankAcc 
             * @return closeBankAccResponse 
         */
        
                 public es.upm.fi.sos.upmbank.CloseBankAccResponse closeBankAcc
                  (
                  es.upm.fi.sos.upmbank.CloseBankAcc closeBankAcc
                  )
            {
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#closeBankAcc");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param logout 
             * @return  
         */
        
                 public void logout
                  (
                  es.upm.fi.sos.upmbank.Logout logout
                  )
            {
                //TODO : fill this with the necessary business logic
                	 //es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub stub = users.get(instance);
                	if(users.containsKey(instance)){
                		users.remove(instance);
                	}
                
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param removeUser 
             * @return removeUserResponse 
         */
        
                 public es.upm.fi.sos.upmbank.RemoveUserResponse removeUser
                  (
                  es.upm.fi.sos.upmbank.RemoveUser removeUser
                  )
            {
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#removeUser");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param addWithdrawal 
             * @return addWithdrawalResponse 
         */
        
                 public es.upm.fi.sos.upmbank.AddWithdrawalResponse addWithdrawal
                  (
                  es.upm.fi.sos.upmbank.AddWithdrawal addWithdrawal
                  )
            {
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#addWithdrawal");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param addUser 
             * @return addUserResponse 
         */
        
                 public es.upm.fi.sos.upmbank.AddUserResponse addUser
                  (
                  es.upm.fi.sos.upmbank.AddUser addUser
                  )
            {
                //TODO : fill this with the necessary business logic
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#addUser");
                	 
                	 es.upm.fi.sos.upmbank.AddUserResponse response = new es.upm.fi.sos.upmbank.AddUserResponse();
                	 es.upm.fi.sos.upmbank.xsd.AddUserResponse param = new es.upm.fi.sos.upmbank.xsd.AddUserResponse();
                	 
                	 if(this.name == "admin"){
                		 es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub stub;
						try {
							 //Check if user exist
							 es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.ExistUser existUser4 = 
									 new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.ExistUser();
							
							es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.ExistUserResponseE existUserResponse = 
									new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.ExistUserResponseE();
							es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.Username username = 
									new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.Username();
							username.setName(addUser.getArgs0().getUsername());
							existUser4.setUsername(username);
							existUserResponse = stub.existUser(existUser4);
							
							if(existUserResponse.get_return().getResult() == true){
		                		 param.setResponse(false);
		                		 response.set_return(param);
							}
							
							stub = new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub();
	
	     					es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.AddUserResponse userResponse = 
	     							new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.AddUserResponse();
	     					es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.AddUser addUser2 = 
	     							new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.AddUser();
	     					es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.UserBackEnd addUserBack = 
	     							new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.UserBackEnd();
	     					
	     					String newUser = addUser.localArgs0.getUsername();
	     					addUserBack.setName(newUser);
	     					addUser2.setUser(addUserBack);
     					
							//userResponse = stub.startaddUser(addUser2, new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonCallbackHandler());
							userResponse = stub.addUser(addUser2);
	     					
							param.setPwd(userResponse.get_return().getPassword());
							param.setResponse(userResponse.get_return().getResult());
							
							
							response.set_return(param);
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (AxisFault e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
     					
                	 }else{
                		 param.setResponse(false);
                		 response.set_return(param);
                	 }               	 
                	 
                	 return response;
            }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param addIncome 
             * @return addIncomeResponse 
         */
        
                 public es.upm.fi.sos.upmbank.AddIncomeResponse addIncome
                  (
                  es.upm.fi.sos.upmbank.AddIncome addIncome
                  )
            {
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#addIncome");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param login 
             * @return loginResponse 
         */
        
                 public es.upm.fi.sos.upmbank.LoginResponse login
                  (
                  es.upm.fi.sos.upmbank.Login login
                  )
            {
                	 
                	
                //TODO : fill this with the necessary business logic
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#login");
                String name = login.getArgs0().getName();
                String psw = login.getArgs0().getPwd();
                
                if(name == "admin"){
                	if(psw == superUserPSW){
                        LoginResponse response = new LoginResponse();
                		es.upm.fi.sos.upmbank.xsd.Response returnResponse = new es.upm.fi.sos.upmbank.xsd.Response(); 
    					returnResponse.setResponse(true);
    					response.set_return(returnResponse);
    					
    					instance = instanceCounter;
    					instanceCounter++;    					
    					users.put(instance, null);
    					this.name = name;
    					
                		return response;
                	}else{
                		LoginResponse response = new LoginResponse();
                		es.upm.fi.sos.upmbank.xsd.Response returnResponse = new es.upm.fi.sos.upmbank.xsd.Response(); 
    					returnResponse.setResponse(false);
    					response.set_return(returnResponse);
    					
    					//No guardamos datos de esta conexion ya que el  usuario no se pude conectar
                		return response;
                	}
                }
                
                es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub stub;
                es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.LoginResponse stubResponse;
				es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.Login login6;
                LoginResponse response = new LoginResponse();
               
                try {
					stub = new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub();
					stub._getServiceClient().getOptions().setManageSession(true);
					stub._getServiceClient().engageModule("addressing");
					stub._getServiceClient().getOptions().setUseSeparateListener(true);
					//Send info to the Server
					login6 = new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.Login();
					es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.LoginBackEnd param;
					param = new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.LoginBackEnd();
					param.setName(name);
					param.setPassword(psw);
					login6.setLogin(param);
					
					
					stubResponse = stub.login(login6);
					
					//Translate to Response					
					boolean resp = stubResponse.get_return().getResult();
					
					if(resp == true){
						instance = instanceCounter;
						instanceCounter++;
						users.put(instance, stub);
						this.name = name; //We don't really need this, it only serve to know who is the super user
					}else{
						//Nada, no guardamos rasgos
					}
					es.upm.fi.sos.upmbank.xsd.Response returnResponse = new es.upm.fi.sos.upmbank.xsd.Response(); 
					returnResponse.setResponse(resp);
					response.set_return(returnResponse);
					
				} catch (AxisFault e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

                return response;
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param getMyMovements 
             * @return getMyMovementsResponse 
         */
        
                 public es.upm.fi.sos.upmbank.GetMyMovementsResponse getMyMovements
                  (
                  es.upm.fi.sos.upmbank.GetMyMovements getMyMovements
                  )
            {
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#getMyMovements");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param changePassword 
             * @return changePasswordResponse 
         */
        
                 public es.upm.fi.sos.upmbank.ChangePasswordResponse changePassword
                  (
                  es.upm.fi.sos.upmbank.ChangePassword changePassword
                  )
            {
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#changePassword");
        }
     
    }
    