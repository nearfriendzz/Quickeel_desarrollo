using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ServiceModel;
using System.Runtime.Serialization;

namespace QuickService.DataContracts
{
    [DataContract]
    public class UserRequest
    {

       
       
           

            [DataMember(Name = "fullname")]
            public string Fullname
            {
                get;
                set;
            }
            [DataMember(Name = "email")]
            public string Email
            {
                get;
                set;
            }
            [DataMember(Name = "password")]
            public string Password
            {
                get;
                set;
            }
        
        
    }
}