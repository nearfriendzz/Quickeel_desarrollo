using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using QuickService.DataContracts;

namespace QuickService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IService1" in both code and config file together.
    [ServiceContract]
    public interface IWSQuickeel
    {

        [OperationContract]
        [WebInvoke(Method = "POST",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            UriTemplate = "TestPost")]
        string TestPost(TestModel tm);

        [OperationContract]
        [WebInvoke(Method = "POST",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            UriTemplate = "InicioSesion")]
        [FaultContract(typeof(UserResponde))]
        UserResponde InicioSesion(string email, string password);

        [OperationContract]
        [WebInvoke(Method = "POST",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            UriTemplate = "PostRegister")]
        string PostRegister(UserRequest user);


        [OperationContract]
        string GetData(int value);

        [OperationContract]
        [WebInvoke(
          Method = "GET",
          UriTemplate = "Hello",
          BodyStyle = WebMessageBodyStyle.Wrapped,
          ResponseFormat = WebMessageFormat.Json,
          RequestFormat = WebMessageFormat.Json)]
        string Hello();

     

        [OperationContract]
        [WebInvoke(
              
              Method = "POST",
              BodyStyle = WebMessageBodyStyle.Wrapped,
              ResponseFormat = WebMessageFormat.Json, 
              RequestFormat = WebMessageFormat.Json)]
        string DoLogin(UserRequest user);
        // TODO: Add your service operations here

        [WebInvoke(Method = "POST", ResponseFormat = WebMessageFormat.Json, RequestFormat = WebMessageFormat.Json, BodyStyle = WebMessageBodyStyle.WrappedRequest)]
        string SendMessageByPost1(string message, int value);

        

    }



}
