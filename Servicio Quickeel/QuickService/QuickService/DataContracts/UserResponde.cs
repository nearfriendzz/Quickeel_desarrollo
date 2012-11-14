using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ServiceModel;
using System.Runtime.Serialization;

namespace QuickService.DataContracts
{
    [DataContract]
    public class UserResponde
    {

       
            [DataMember(Name = "iduser")]
            public int IDUser
            {
                get;
                set;
            }

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
            [DataMember(Name = "createdate")]
            public DateTime CreateDate
            {
                get;
                set;
            }
            [DataMember(Name = "createupdate")]
            public DateTime CreateUpdate
            {
                get;
                set;
            }

            [DataMember(Name = "messageerror")]
            public string MessageError
            {
                get;
                set;
            }


        
    }
}