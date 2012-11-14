using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ServiceModel;
using System.Runtime.Serialization;

namespace QuickService.DataContracts
{

    [DataContract]
    public class TestModel
    {
        [DataMember(Name = "p1")]
        public string p1 { get; set; }

        [DataMember(Name = "p2")]
        public string p2 { get; set; }

        [DataMember(Name = "p3")]
        public int p3 { get; set; }

        [DataMember(Name = "p4")]
        public string p4 { get; set; }

        [DataMember(Name = "p5")]
        public int p5 { get; set; }

        [DataMember(Name = "p6")]
        public string p6 { get; set; }
    }
}