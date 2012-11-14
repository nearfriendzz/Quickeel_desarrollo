using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using QuickService.DataContracts;
using System.Data.EntityClient;
using System.Data.SqlClient;
using System.Configuration;
using System.Data.OleDb;
using System.Web;
using System.ServiceModel.Activation;

namespace QuickService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service1" in code, svc and config file together.
    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Allowed)]
    public class WSQuickeel : IWSQuickeel
    {
        UserResponde erroresponde = new UserResponde();
        private string connectionString = "Provider=SQLOLEDB;Data Source=db439330498.db.1and1.com,1433;Initial Catalog=db439330498;User Id=dbo439330498;Password=me109cito;"; //"Data Source=jobplinserver;Initial Catalog=desarrollo;User ID=junggla;Password=1234567";
        //private string connectionString = ConfigurationManager.ConnectionStrings["SiteSqlServer"].ToString(); 
        /*private string str = ConfigurationManager.ConnectionStrings["SiteSqlServer"].ToString();*/
       
        //public string GetData(int value)
        //{
        //    return string.Format("You entered: {0}", value);
        //}

        //public CompositeType GetDataUsingDataContract(CompositeType composite)
        //{
        //    if (composite == null)
        //    {
        //        throw new ArgumentNullException("composite");
        //    }
        //    if (composite.BoolValue)
        //    {
        //        composite.StringValue += "Suffix";
        //    }
        //    return composite;
        //}


  //      public string DoLogin(UserRequest request)
  //      {

  //          string lblResult = string.Empty; ;

  //      string selectSQL = "SELECT Pk_User, Fullname, Email,Password,CreateDate,CreateUpdate FROM Users where Email = @email and Password = @password";

  //      SqlConnection con = new SqlConnection(connectionString);
  //      SqlCommand cmd = new SqlCommand(selectSQL, con);
  //      cmd.Parameters.AddWithValue("@email", request.Email);
  //      cmd.Parameters.AddWithValue("@password", request.Password);

  //      SqlDataReader reader;
  //      UserResponde responde = new UserResponde();
           

  //      try
  //      {
  //          con.Open();
  //          reader = cmd.ExecuteReader();
  //          while (reader.Read())
  //          {
            
  //              responde.IDUser = Convert.ToInt32(reader["Pk_User"].ToString());
  //              if (responde.IDUser == 0) {

  //                  lblResult = "0";
  //                  return lblResult;
                    
  //              }else
  //              {
  //                  lblResult = "1";
  //                  return lblResult;
  //              }


  //              //responde.Fullname = reader["Fullname"].ToString();
  //              //responde.Email = reader["Email"].ToString();
  //              //responde.Password = reader["Password"].ToString();
  //              //responde.CreateDate = Convert.ToDateTime(reader["CreateDate"].ToString());
  //              //responde.CreateUpdate =  Convert.ToDateTime(reader["CreateUpdate"].ToString());
  //              //responde.Fullname = reader["Fullname"].ToString();
  //              //responde.Email = reader["Email"].ToString();
  //              //responde.Password = reader["Password"].ToString();
  //              //responde.CreateDate = Convert.ToDateTime(reader["CreateDate"].ToString());
  //              //responde.CreateUpdate =  Convert.ToDateTime(reader["CreateUpdate"].ToString());


                
  //          }
  //          reader.Close();
            
  //      }
  //      catch (Exception err)
  //      {
  //          lblResult = "Exception jope!!!! ";
  //          lblResult += err.Message;
            
  //      }
  //      finally
  //      {
  //          con.Close();
  //      }

  //      return lblResult;
  //}

        /// <summary>
        /// Registrar usuario
        /// </summary>
        /// <param name="user"></param>
        /// <returns></returns>
        public string PostRegister(UserRequest user)
        {
            //  insertSQL += "phone, address, city, state, zip, contract) ";
            string lblResult;
            string insertSQL;
            insertSQL = "INSERT INTO Users (";
            insertSQL += "Fullname, Email, Password, CreateDate,CreateUpdate) ";
            insertSQL += "VALUES (";
            insertSQL += "?,?, ?, ";
            insertSQL += "?, ?)";

            OleDbConnection con = new OleDbConnection(connectionString);
            
            OleDbCommand cmd = new OleDbCommand(insertSQL, con);

            cmd.Parameters.Add("@Fullname",OleDbType.VarChar,100).Value = user.Fullname;
            cmd.Parameters.Add("@Email", OleDbType.VarChar, 100).Value = user.Email;
            cmd.Parameters.Add("@Password", OleDbType.VarChar, 100).Value = user.Password;
            cmd.Parameters.Add("@CreateDate", OleDbType.Date).Value = DateTime.Now;
            cmd.Parameters.Add("@CreateUpdate", OleDbType.Date).Value = DateTime.Now;
           // cmd.Parameters.AddWithValue("@city", txtCity.Text);
            //cmd.Parameters.AddWithValue("@state", txtState.Text);
            //cmd.Parameters.AddWithValue("@zip", txtZip.Text);
            //cmd.Parameters.AddWithValue("@contract", Convert.ToInt16(chkContract.Checked));

            int added = 0;
            try
            {
                con.Open();

                int i = VerificarEmail(user.Email);
                if (i == 0)
                {
                    added = cmd.ExecuteNonQuery();
                    // lblResult = added.ToString(); 
                    return GetIdUser(user.Email).ToString();
                         
                  

                }
                else { 
                        return "0";
                }
            }
            catch (Exception err)
            {
                lblResult = "Error inserting record. ";
                lblResult += err.Message;
                return lblResult;
            }
            finally
            {
                con.Close();
            }           

        }


        /// <summary>
        /// Inicia sesion del usuario
        /// </summary>
        /// <param name="email"></param>
        /// <param name="password"></param>
        /// <returns></returns>
        public UserResponde InicioSesion(string email, string password)
        {
            
        

            string selectSQL = "SELECT Pk_User, Fullname, Email,Password,CreateDate,CreateUpdate FROM Users where Email = ? and Password = ?";
             UserResponde respondeUser = new UserResponde();
            //SqlConnection con = new SqlConnection(connectionString);
            //SqlCommand cmd = new SqlCommand(selectSQL, con);

            OleDbConnection con = new OleDbConnection(connectionString);
            OleDbCommand cmd = new OleDbCommand(selectSQL, con);

            cmd.Parameters.Add("@Email", OleDbType.VarChar).Value = email;
            cmd.Parameters.Add("@Password", OleDbType.VarChar).Value = password;
            //cmd.Parameters.Add("@Email", System.Data.SqlDbType.VarChar).Value = email;
            //cmd.Parameters.Add("@Password", System.Data.SqlDbType.VarChar).Value = password;

            //SqlDataReader reader;
            OleDbDataReader reader ;



            try
            {

                con.Open();
                reader = cmd.ExecuteReader();

                    while (reader.Read())
                    {

                        respondeUser.IDUser = Convert.ToInt32(reader["Pk_User"].ToString());
                        if (respondeUser.IDUser == 0)
                        {

                            respondeUser.MessageError = "0";

                        }
                        else
                        {
                            respondeUser.Fullname = reader["Fullname"].ToString();
                            respondeUser.Email = reader["Email"].ToString();
                            respondeUser.Password = reader["Password"].ToString();
                            respondeUser.CreateDate = Convert.ToDateTime(reader["CreateDate"].ToString());
                            respondeUser.CreateUpdate = Convert.ToDateTime(reader["CreateUpdate"].ToString());
                            respondeUser.MessageError = "1";
                        }

                    }
                    reader.Close();
                    cmd.Dispose();
                    con.Close(); 
              
            }
            catch (FaultException err)
            {
                
                //respondeUser.MessageError = "Exception jope la hemos liado :(!!!! ";
                //
                string json = err.Message + " Pila de Error" + Convert.ToString(err.StackTrace);
                HttpContext.Current.Response.ContentType = "application/json; charset=utf-8";
                HttpContext.Current.Response.Write(json);
                erroresponde.Fullname = "";
                erroresponde.IDUser = 0;
                erroresponde.Fullname = "";
                erroresponde.Email = "";
                erroresponde.MessageError = json;
                respondeUser.MessageError = erroresponde.MessageError;
                //return erroresponde;
                throw new FaultException<UserResponde>(respondeUser);
            }
            
            return respondeUser;
        }

        private int GetIdUser(string email)
        {

            string selectSQL = "SELECT Pk_User FROM Users where Email = ?";
            int result = 0;
            UserResponde respondeUser = new UserResponde();
            //SqlConnection con = new SqlConnection(connectionString);
            //SqlCommand cmd = new SqlCommand(selectSQL, con);

            OleDbConnection con = new OleDbConnection(connectionString);

            OleDbCommand cmd = new OleDbCommand(selectSQL, con);

            cmd.Parameters.Add("@Email", OleDbType.VarChar).Value = email;

            //cmd.Parameters.Add("@Email", System.Data.SqlDbType.VarChar).Value = email;
            //cmd.Parameters.Add("@Password", System.Data.SqlDbType.VarChar).Value = password;

            //SqlDataReader reader;
            OleDbDataReader reader;



            try
            {

                con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {

                    respondeUser.IDUser = Convert.ToInt32(reader["Pk_User"].ToString());
                    //respondeUser.Fullname = reader["Fullname"].ToString();
                    //respondeUser.Password = reader["Password"].ToString();
                    //respondeUser.CreateDate = Convert.ToDateTime(reader["CreateDate"].ToString());
                    //respondeUser.CreateUpdate = Convert.ToDateTime(reader["CreateUpdate"].ToString());
                    //respondeUser.MessageError = "0";
                }
                reader.Close();

                if (respondeUser.IDUser == 0)
                {

                    result = 0;

                }
                else
                {
                    result = respondeUser.IDUser;
                }


            }
            catch (Exception err)
            {
                respondeUser.MessageError = "Exception jope la hemos liado :(!!!! ";
                respondeUser.MessageError += err.Message;
                result = -1;
            }
            finally
            {
                con.Close();
            }

            return result;

        }
        private int VerificarEmail(string email){

            string selectSQL = "SELECT Pk_User FROM Users where Email = ?";
            int result = 0;
            UserResponde respondeUser = new UserResponde();
            //SqlConnection con = new SqlConnection(connectionString);
            //SqlCommand cmd = new SqlCommand(selectSQL, con);

            OleDbConnection con = new OleDbConnection(connectionString);

            OleDbCommand cmd = new OleDbCommand(selectSQL, con);

            cmd.Parameters.Add("@Email", OleDbType.VarChar).Value = email;
         
            //cmd.Parameters.Add("@Email", System.Data.SqlDbType.VarChar).Value = email;
            //cmd.Parameters.Add("@Password", System.Data.SqlDbType.VarChar).Value = password;

            //SqlDataReader reader;
            OleDbDataReader reader;



            try
            {

                con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {

                    respondeUser.IDUser = Convert.ToInt32(reader["Pk_User"].ToString());
                    //respondeUser.Fullname = reader["Fullname"].ToString();
                    //respondeUser.Password = reader["Password"].ToString();
                    //respondeUser.CreateDate = Convert.ToDateTime(reader["CreateDate"].ToString());
                    //respondeUser.CreateUpdate = Convert.ToDateTime(reader["CreateUpdate"].ToString());
                    //respondeUser.MessageError = "0";
                }
                reader.Close();

                if (respondeUser.IDUser == 0)
                {

                    result = 0;

                }
                else
                {
                    result = 1;
                }


            }
            catch (Exception err)
            {
                respondeUser.MessageError = "Exception jope la hemos liado :(!!!! ";
                respondeUser.MessageError += err.Message;
                result = -1;
            }
            finally
            {
                con.Close();
            }

            return result;
        
        }
        public string GetData(int value)
        {
            throw new NotImplementedException();
        }

        public string DoLogin(UserRequest user)
        {
            throw new NotImplementedException();
        }

        public string Hello()
            {
                return "Hola Mundo por fin";
            }

        public string TestPost(TestModel tm)
        {
            return tm.p1+"hola por fin robinson lo hiciste";
        }

        public string SendMessageByPost1(string message, int value)
        {
            return DateTime.Now + " PostMessage:" + message + value;
        }


       
    }
}
