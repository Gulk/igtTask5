

/**
 * DiscountCalcTest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package task5;

    /*
     *  DiscountCalcTest Junit test case
    */

    public class DiscountCalcTest extends junit.framework.TestCase{

     
        /**
         * Auto generated test method
         */
        public  void testgetDiscountAmount() throws java.lang.Exception{

        task5.DiscountCalcStub stub =
                    new task5.DiscountCalcStub();//the default implementation should point to the right endpoint

           task5.DiscountCalcStub.GetDiscountAmount getDiscountAmount4=
                                                        (task5.DiscountCalcStub.GetDiscountAmount)getTestObject(task5.DiscountCalcStub.GetDiscountAmount.class);

                		getDiscountAmount4.setUsername("Deadpool");
                        assertNotNull(stub.getDiscountAmount(
                        getDiscountAmount4));
                  



        }
        
         /**
         * Auto generated test method
         */
        public  void testStartgetDiscountAmount() throws java.lang.Exception{
            task5.DiscountCalcStub stub = new task5.DiscountCalcStub();
             task5.DiscountCalcStub.GetDiscountAmount getDiscountAmount4=
                                                        (task5.DiscountCalcStub.GetDiscountAmount)getTestObject(task5.DiscountCalcStub.GetDiscountAmount.class);
                
             	getDiscountAmount4.setUsername("Deadpool");
                stub.startgetDiscountAmount(
                         getDiscountAmount4,
                    new tempCallbackN65548()
                );
              


        }

        private class tempCallbackN65548  extends task5.DiscountCalcCallbackHandler{
            public tempCallbackN65548(){ super(null);}

            public void receiveResultgetDiscountAmount(
                         task5.DiscountCalcStub.GetDiscountAmountResponse result
                            ) {
                
            }

            public void receiveErrorgetDiscountAmount(java.lang.Exception e) {
                fail();
            }

        }
      
        //Create an ADBBean and provide it as the test object
        public org.apache.axis2.databinding.ADBBean getTestObject(java.lang.Class type) throws java.lang.Exception{
           return (org.apache.axis2.databinding.ADBBean) type.newInstance();
        }

        
        

    }
    