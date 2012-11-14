using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ServiceModel;
using System.Runtime.Serialization;

namespace QuickeelServices
{
    [DataContract]
    public class LoginData
    {
        [DataMember(Name="Email")]
        public string Email
        {
            get;
            set;
        }

        [DataMember(Name = "Password")]
        public string Password
        {
            get;
            set;
        }


    }
}