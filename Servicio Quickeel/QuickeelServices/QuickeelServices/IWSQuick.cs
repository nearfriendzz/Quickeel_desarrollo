using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using System.ServiceModel.Web;

namespace QuickeelServices
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IWSQuick" in both code and config file together.
    [ServiceContract(Namespace = "http://services.example.com")]
    public interface IWSQuick
    {
        [OperationContract]
        [WebInvoke(
              Method = "POST",
              UriTemplate = "DoLogin",
              BodyStyle = WebMessageBodyStyle.WrappedRequest,
              ResponseFormat = WebMessageFormat.Json,
              RequestFormat = WebMessageFormat.Json)]
        int DoLogin(LoginData login);
    }
}
