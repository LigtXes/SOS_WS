
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
    			new HashMap<>(); //<instance, Stub>
    	private static Map<String, String> password = 
    	 		new HashMap<>(); //<Username, password>
    	private static Map<String, Map<es.upm.fi.sos.upmbank.xsd.BankAccount, es.upm.fi.sos.upmbank.xsd.Deposit>> bankAcc = 
    			new HashMap<>(); //<Username, <BankAccount (IBAN), Deposit>>
    	private static Map<String, List<es.upm.fi.sos.upmbank.xsd.Movement>> movementList = 
    			new HashMap<>(); //<Username, Movement (withdraw and income)>
    			
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
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#addBankAcc");
                	 es.upm.fi.sos.upmbank.AddBankAccResponse response =
                			 new es.upm.fi.sos.upmbank.AddBankAccResponse();
                	 es.upm.fi.sos.upmbank.xsd.BankAccountResponse param = 
                			 new es.upm.fi.sos.upmbank.xsd.BankAccountResponse();
                	 
                	 if(name != null & addBankAcc.isArgs0Specified() & addBankAcc.localArgs0.isQuantitySpecified()){ //We stop at the first one who is false
                		 es.upm.fi.sos.upmbank.xsd.BankAccount bankAccount = 
                				 new es.upm.fi.sos.upmbank.xsd.BankAccount();
                		 es.upm.fi.sos.upmbank.xsd.Deposit bankDeposit = 
                				 new es.upm.fi.sos.upmbank.xsd.Deposit();
                		 int num = bankAcc.get(name).size();
                		 bankAccount.setIBAN(name+num);
                		 bankDeposit.setQuantity(addBankAcc.localArgs0.getQuantity());
                		 
                		 bankAcc.get(name).put(bankAccount, bankDeposit); //Account is created
                		 
                		 param.setIBAN(bankAccount.getIBAN());
                		 param.setResult(true);
                		 response.set_return(param);
                		 return response;
                	 }else{
                		 param.setResult(false);
                		 response.set_return(param);
                		 return response;
                	 }
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
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#closeBankAcc");
                	 es.upm.fi.sos.upmbank.CloseBankAccResponse response = 
                			 new es.upm.fi.sos.upmbank.CloseBankAccResponse();
                	 es.upm.fi.sos.upmbank.xsd.Response param = 
                			 new es.upm.fi.sos.upmbank.xsd.Response();
                	 
                	 if(name != null & closeBankAcc.localArgs0Tracker & closeBankAcc.localArgs0.isIBANSpecified()){
                		 //Connect
                		 String IBAN = closeBankAcc.getArgs0().getIBAN();
                		 
             
                		 if(!bankAcc.get(name).containsKey(IBAN)){
                			 //En ese caso la cuenta especificada no existe
                			 param.setResponse(false);
                			 response.set_return(param);
                			 return response;
                		 }
                		 es.upm.fi.sos.upmbank.xsd.Deposit deposit = bankAcc.get(name).get(IBAN);
                		 
                		 if(deposit.getQuantity() != 0){
                			 //Comprobamos que la cuenta es igual a 0
                			 param.setResponse(false);
                			 response.set_return(param);
                			 return response;
                		 }
                		 
                		 bankAcc.get(name).remove(IBAN); //Boramos la cuenta tras haberlo controlado todo
                		 
                		 param.setResponse(true);
                		 response.set_return(param);
                		 return response;

                	 }else{
                		 //Not connect or something wrong on closeBankAcc
                		 param.setResponse(false);
                		 response.set_return(param);
                		 return response;
                	 }
                	 
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
                	name = null; //Eso nos permite saber que ya no esta identificado
                
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
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#removeUser");
                	 es.upm.fi.sos.upmbank.RemoveUserResponse response = new es.upm.fi.sos.upmbank.RemoveUserResponse();
                	 es.upm.fi.sos.upmbank.xsd.Response param = new es.upm.fi.sos.upmbank.xsd.Response();
                	 if(name.equals("admin")){
                		 String username = removeUser.localArgs0.getUsername();
                		 if(username.equals("admin")){
                			 //No se puede borrar el administrador
                			 param.setResponse(false);
                			 response.set_return(param);
                			 return response;
                		 }else{
                			 try{
                				 String psw = password.get(username);
                				 
                				 if(bankAcc.get(username).size() != 0){
                					 //El usuario aun tiene cuentas bancarias
                					 param.setResponse(false);
                        			 response.set_return(param);
                        			 return response;
                				 }
                				 
	                    		 es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub stub = 
	                    				 new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub();
	                    		 es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUserResponseE responseFromServer = 
	                    				 new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUserResponseE();
	                    		 es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUserE removeUserToServer = 
	                    				 new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUserE();
	                    		 es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUser paramServ = 
	                    				 new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUser();
	                    		 
	                    		 paramServ.setName(username);
	                    		 paramServ.setPassword(psw);
	                    		 removeUserToServer.setRemoveUser(paramServ);
	                    		 responseFromServer = stub.removeUser(removeUserToServer);
	                    		 
	                    		 param.setResponse(responseFromServer.get_return().getResult());
	                    		 response.set_return(param);
	                    		 return response;
	                    		 
                			 } catch (RemoteException e){
                				 e.printStackTrace();
                			 }
                    		 
                		 }
                	 }else{
                		 //Solo el administrador puede borrar
                		 param.setResponse(false);
                		 response.set_return(param);
                		 return response;
                	 }
                	 
                	 
                	 return response;
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
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#addWithdrawal");
                	//throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#addIncome");
                	 es.upm.fi.sos.upmbank.AddWithdrawalResponse response = 
                			 new es.upm.fi.sos.upmbank.AddWithdrawalResponse();
                	 es.upm.fi.sos.upmbank.xsd.AddMovementResponse param = 
                			 new es.upm.fi.sos.upmbank.xsd.AddMovementResponse();
                	 if(name != null &
                			 addWithdrawal.localArgs0Tracker &
                			 addWithdrawal.localArgs0.isIBANSpecified() &
                			 addWithdrawal.localArgs0.isQuantitySpecified()){
                		 //Connect
                		 
                		 es.upm.fi.sos.upmbank.xsd.Movement movement = 
                				 new es.upm.fi.sos.upmbank.xsd.Movement();
                		 String IBAN = addWithdrawal.getArgs0().getIBAN();
                		 double withdraw = addWithdrawal.getArgs0().getQuantity();
                		 
                		 if(!bankAcc.get(name).containsKey(IBAN)){
                			 param.setResult(false);
                			 response.set_return(param);
                			 return response;
                		 }
                		 
                		 double deposit = bankAcc.get(name).get(IBAN).getQuantity();
                		 double newDeposite = deposit - withdraw;
                		 
                		 if(newDeposite < 0){
                			 param.setResult(false);
                			 response.set_return(param);
                			 return response;
                		 }
                		 
                		 bankAcc.get(name).get(IBAN).setQuantity(newDeposite);
                		 
                		 movement.setIBAN(IBAN);
                		 movement.setQuantity(withdraw * (-1)); //We multiply per -1 to know it's a withdraw
                		 movementList.get(name).add(movement);
                		 
                		 param.setBalance(newDeposite);
                		 param.setResult(true);
                		 response.set_return(param);
                		 return response;                		 
                		 
                		 
                	 }else{
                		 //Not connect or not specified value
                		 param.setResult(false);
                		 response.set_return(param);
                		 return response;
                	 }
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
                	 
                	 System.out.println("Add User Service");
                	 es.upm.fi.sos.upmbank.AddUserResponse response = new es.upm.fi.sos.upmbank.AddUserResponse();
                	 es.upm.fi.sos.upmbank.xsd.AddUserResponse param = new es.upm.fi.sos.upmbank.xsd.AddUserResponse();
                	 
                	 
                	 if(this.name.equals("admin")){
                		 
						try {
							es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub stub = 
	                				 new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub();
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
						} catch (AxisFault e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
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
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#addIncome");
                	 es.upm.fi.sos.upmbank.AddIncomeResponse response = 
                			 new es.upm.fi.sos.upmbank.AddIncomeResponse();
                	 es.upm.fi.sos.upmbank.xsd.AddMovementResponse param = 
                			 new es.upm.fi.sos.upmbank.xsd.AddMovementResponse();
                	 
                	 if(name != null &
                			 addIncome.localArgs0Tracker &
                			 addIncome.localArgs0.isIBANSpecified() &
                			 addIncome.localArgs0.isQuantitySpecified()){
                		 //Connect
                		 
                		 es.upm.fi.sos.upmbank.xsd.Movement movement = 
                				 new es.upm.fi.sos.upmbank.xsd.Movement();
                		 String IBAN = addIncome.getArgs0().getIBAN();
                		 double income = addIncome.getArgs0().getQuantity();
                		 
                		 if(!bankAcc.get(name).containsKey(IBAN)){
                			 param.setResult(false);
                			 response.set_return(param);
                			 return response;
                		 }
                		 
                		 double deposit = bankAcc.get(name).get(IBAN).getQuantity();
                		 double newDeposite = income + deposit;
                		 bankAcc.get(name).get(IBAN).setQuantity(newDeposite);
                		 
                		 movement.setIBAN(IBAN);
                		 movement.setQuantity(income);
                		 movementList.get(name).add(movement);
                		 
                		 param.setBalance(newDeposite);
                		 param.setResult(true);
                		 response.set_return(param);
                		 return response;                		 
                		 
                		 
                	 }else{
                		 //Not connect or not specified value
                		 param.setResult(false);
                		 response.set_return(param);
                		 return response;
                	 }
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
                
                System.out.println("Username: "+name+" Password: "+psw);
                System.out.println("Super admin password: "+superUserPSW);
                if(name.equals("admin")){
                	if(psw.equals(superUserPSW)){
                        LoginResponse response = new LoginResponse();
                		es.upm.fi.sos.upmbank.xsd.Response returnResponse = new es.upm.fi.sos.upmbank.xsd.Response(); 
    					returnResponse.setResponse(true);
    					response.set_return(returnResponse);
    					
    					instance = instanceCounter;
    					instanceCounter++;    					
    					users.put(instance, null);
    					this.name = name;
    					if(!bankAcc.containsKey(name)){
							//Initialize bankAcc map
							bankAcc.put(name, new HashMap<es.upm.fi.sos.upmbank.xsd.BankAccount, es.upm.fi.sos.upmbank.xsd.Deposit>());
						}
    					if(!movementList.containsKey(name)){
    						movementList.put(name, new ArrayList<es.upm.fi.sos.upmbank.xsd.Movement>());
    					}
    					
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
					//stub._getServiceClient().engageModule("addressing");
					//stub._getServiceClient().getOptions().setUseSeparateListener(true);
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
						password.putIfAbsent(name, psw);
						if(!bankAcc.containsKey(name)){
							//Initialize bankAcc map
							bankAcc.put(name, new HashMap<>());
						}
						this.name = name;
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
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#getMyMovements");
                	 es.upm.fi.sos.upmbank.GetMyMovementsResponse response = 
                			 new es.upm.fi.sos.upmbank.GetMyMovementsResponse();
                	 es.upm.fi.sos.upmbank.xsd.MovementList param = 
                			 new es.upm.fi.sos.upmbank.xsd.MovementList();
                	 
                	 if(name != null){
                		 int arraySize = movementList.get(name).size();
                		 double[] movement;
                		 if(arraySize <= 10){
                			 movement = new double[arraySize];
                			 int i = 0;
                			 for(es.upm.fi.sos.upmbank.xsd.Movement m: movementList.get(name)){
                				movement[i] = m.getQuantity();
                				i++;
                			 }
                		 }else{
                			 movement = new double[10];
                			 List<es.upm.fi.sos.upmbank.xsd.Movement> tenLastMovement = 
                					 movementList.get(name).subList(movementList.get(name).size() - 10, movementList.get(name).size());
                			 int i = 0;
                			 for(es.upm.fi.sos.upmbank.xsd.Movement m: tenLastMovement){
                				 movement[i] = m.getQuantity();
                				 i++;
                			 }
                		 }
                		 
                		 param.setResult(true);
                		 param.setMovementQuantities(movement);
                		 response.set_return(param);
                		 return response;
                		 

                	 }else{
                		 //Doesn't connect or any other problem
                		 param.setResult(false);
                		 response.set_return(param);
                		 return response;
                	 }
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
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#changePassword");
                	 es.upm.fi.sos.upmbank.ChangePasswordResponse response = 
                			 new es.upm.fi.sos.upmbank.ChangePasswordResponse();
                	 
                	 es.upm.fi.sos.upmbank.xsd.Response param = 
                			 new es.upm.fi.sos.upmbank.xsd.Response();
                	 
                	 String old = changePassword.localArgs0.getOldpwd();
                	 String newPsw = changePassword.localArgs0.getNewpwd();
                	 
                	 if(name.equals("admin")){
                		 if(superUserPSW.equals(old)){
                			 superUserPSW = newPsw;
                			 param.setResponse(true);
                			 response.set_return(param);
                			 return response; 
                		 }else{
                			 param.setResponse(false);
                			 response.set_return(param);
                			 return response;
                		 }
                	 }
                	 else if(password.get(name).equals(old)){
                		 try{
	                		 es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub stub;
	                		 stub = users.get(instance);
	                		 
	                		 es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePasswordResponseE responseFromServ = 
	                				 new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePasswordResponseE();
	                		 es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePassword server = 
	                				 new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePassword();
	                		 es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePasswordBackEnd serverParam = 
	                				 new es.upm.fi.sos.t3.backend.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePasswordBackEnd();
	                		 
	                		 serverParam.setName(name);
	                		 serverParam.setOldpwd(old);
	                		 serverParam.setNewpwd(newPsw);
	                		 server.setChangePassword(serverParam);
	                		 
	                		 responseFromServ = stub.changePassword(server);
	                		 
	                		 param.setResponse(responseFromServ.get_return().getResult());
	                		 response.set_return(param);
	                		 return response;
                		 } catch (RemoteException e){
                			 e.printStackTrace();
                		 }
                	 }else{
                		 param.setResponse(false);
            			 response.set_return(param);
            			 return response;
                	 }
                	 return response;
            }
     
    }
    