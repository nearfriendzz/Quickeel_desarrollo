﻿//------------------------------------------------------------------------------
// <auto-generated>
//    Este código se generó a partir de una plantilla.
//
//    Los cambios manuales en este archivo pueden causar un comportamiento inesperado de la aplicación.
//    Los cambios manuales en este archivo se sobrescribirán si se regenera el código.
// </auto-generated>
//------------------------------------------------------------------------------

using System;
using System.Data.Objects;
using System.Data.Objects.DataClasses;
using System.Data.EntityClient;
using System.ComponentModel;
using System.Xml.Serialization;
using System.Runtime.Serialization;

[assembly: EdmSchemaAttribute()]

namespace QuickeelServices
{
    #region Contextos
    
    /// <summary>
    /// No hay documentación de metadatos disponible.
    /// </summary>
    public partial class masterEntities : ObjectContext
    {
        #region Constructores
    
        /// <summary>
        /// Inicializa un nuevo objeto masterEntities usando la cadena de conexión encontrada en la sección 'masterEntities' del archivo de configuración de la aplicación.
        /// </summary>
        public masterEntities() : base("name=masterEntities", "masterEntities")
        {
            this.ContextOptions.LazyLoadingEnabled = true;
            OnContextCreated();
        }
    
        /// <summary>
        /// Inicializar un nuevo objeto masterEntities.
        /// </summary>
        public masterEntities(string connectionString) : base(connectionString, "masterEntities")
        {
            this.ContextOptions.LazyLoadingEnabled = true;
            OnContextCreated();
        }
    
        /// <summary>
        /// Inicializar un nuevo objeto masterEntities.
        /// </summary>
        public masterEntities(EntityConnection connection) : base(connection, "masterEntities")
        {
            this.ContextOptions.LazyLoadingEnabled = true;
            OnContextCreated();
        }
    
        #endregion
    
        #region Métodos parciales
    
        partial void OnContextCreated();
    
        #endregion
    
        #region Propiedades de ObjectSet
    
        /// <summary>
        /// No hay documentación de metadatos disponible.
        /// </summary>
        public ObjectSet<spt_monitor> spt_monitor
        {
            get
            {
                if ((_spt_monitor == null))
                {
                    _spt_monitor = base.CreateObjectSet<spt_monitor>("spt_monitor");
                }
                return _spt_monitor;
            }
        }
        private ObjectSet<spt_monitor> _spt_monitor;

        #endregion
        #region Métodos AddTo
    
        /// <summary>
        /// Método desusado para agregar un nuevo objeto al EntitySet spt_monitor. Considere la posibilidad de usar el método .Add de la propiedad ObjectSet&lt;T&gt; asociada.
        /// </summary>
        public void AddTospt_monitor(spt_monitor spt_monitor)
        {
            base.AddObject("spt_monitor", spt_monitor);
        }

        #endregion
    }
    

    #endregion
    
    #region Entidades
    
    /// <summary>
    /// No hay documentación de metadatos disponible.
    /// </summary>
    [EdmEntityTypeAttribute(NamespaceName="masterModel", Name="spt_monitor")]
    [Serializable()]
    [DataContractAttribute(IsReference=true)]
    public partial class spt_monitor : EntityObject
    {
        #region Método de generador
    
        /// <summary>
        /// Crear un nuevo objeto spt_monitor.
        /// </summary>
        /// <param name="lastrun">Valor inicial de la propiedad lastrun.</param>
        /// <param name="cpu_busy">Valor inicial de la propiedad cpu_busy.</param>
        /// <param name="io_busy">Valor inicial de la propiedad io_busy.</param>
        /// <param name="idle">Valor inicial de la propiedad idle.</param>
        /// <param name="pack_received">Valor inicial de la propiedad pack_received.</param>
        /// <param name="pack_sent">Valor inicial de la propiedad pack_sent.</param>
        /// <param name="connections">Valor inicial de la propiedad connections.</param>
        /// <param name="pack_errors">Valor inicial de la propiedad pack_errors.</param>
        /// <param name="total_read">Valor inicial de la propiedad total_read.</param>
        /// <param name="total_write">Valor inicial de la propiedad total_write.</param>
        /// <param name="total_errors">Valor inicial de la propiedad total_errors.</param>
        public static spt_monitor Createspt_monitor(global::System.DateTime lastrun, global::System.Int32 cpu_busy, global::System.Int32 io_busy, global::System.Int32 idle, global::System.Int32 pack_received, global::System.Int32 pack_sent, global::System.Int32 connections, global::System.Int32 pack_errors, global::System.Int32 total_read, global::System.Int32 total_write, global::System.Int32 total_errors)
        {
            spt_monitor spt_monitor = new spt_monitor();
            spt_monitor.lastrun = lastrun;
            spt_monitor.cpu_busy = cpu_busy;
            spt_monitor.io_busy = io_busy;
            spt_monitor.idle = idle;
            spt_monitor.pack_received = pack_received;
            spt_monitor.pack_sent = pack_sent;
            spt_monitor.connections = connections;
            spt_monitor.pack_errors = pack_errors;
            spt_monitor.total_read = total_read;
            spt_monitor.total_write = total_write;
            spt_monitor.total_errors = total_errors;
            return spt_monitor;
        }

        #endregion
        #region Propiedades primitivas
    
        /// <summary>
        /// No hay documentación de metadatos disponible.
        /// </summary>
        [EdmScalarPropertyAttribute(EntityKeyProperty=true, IsNullable=false)]
        [DataMemberAttribute()]
        public global::System.DateTime lastrun
        {
            get
            {
                return _lastrun;
            }
            set
            {
                if (_lastrun != value)
                {
                    OnlastrunChanging(value);
                    ReportPropertyChanging("lastrun");
                    _lastrun = StructuralObject.SetValidValue(value);
                    ReportPropertyChanged("lastrun");
                    OnlastrunChanged();
                }
            }
        }
        private global::System.DateTime _lastrun;
        partial void OnlastrunChanging(global::System.DateTime value);
        partial void OnlastrunChanged();
    
        /// <summary>
        /// No hay documentación de metadatos disponible.
        /// </summary>
        [EdmScalarPropertyAttribute(EntityKeyProperty=true, IsNullable=false)]
        [DataMemberAttribute()]
        public global::System.Int32 cpu_busy
        {
            get
            {
                return _cpu_busy;
            }
            set
            {
                if (_cpu_busy != value)
                {
                    Oncpu_busyChanging(value);
                    ReportPropertyChanging("cpu_busy");
                    _cpu_busy = StructuralObject.SetValidValue(value);
                    ReportPropertyChanged("cpu_busy");
                    Oncpu_busyChanged();
                }
            }
        }
        private global::System.Int32 _cpu_busy;
        partial void Oncpu_busyChanging(global::System.Int32 value);
        partial void Oncpu_busyChanged();
    
        /// <summary>
        /// No hay documentación de metadatos disponible.
        /// </summary>
        [EdmScalarPropertyAttribute(EntityKeyProperty=true, IsNullable=false)]
        [DataMemberAttribute()]
        public global::System.Int32 io_busy
        {
            get
            {
                return _io_busy;
            }
            set
            {
                if (_io_busy != value)
                {
                    Onio_busyChanging(value);
                    ReportPropertyChanging("io_busy");
                    _io_busy = StructuralObject.SetValidValue(value);
                    ReportPropertyChanged("io_busy");
                    Onio_busyChanged();
                }
            }
        }
        private global::System.Int32 _io_busy;
        partial void Onio_busyChanging(global::System.Int32 value);
        partial void Onio_busyChanged();
    
        /// <summary>
        /// No hay documentación de metadatos disponible.
        /// </summary>
        [EdmScalarPropertyAttribute(EntityKeyProperty=true, IsNullable=false)]
        [DataMemberAttribute()]
        public global::System.Int32 idle
        {
            get
            {
                return _idle;
            }
            set
            {
                if (_idle != value)
                {
                    OnidleChanging(value);
                    ReportPropertyChanging("idle");
                    _idle = StructuralObject.SetValidValue(value);
                    ReportPropertyChanged("idle");
                    OnidleChanged();
                }
            }
        }
        private global::System.Int32 _idle;
        partial void OnidleChanging(global::System.Int32 value);
        partial void OnidleChanged();
    
        /// <summary>
        /// No hay documentación de metadatos disponible.
        /// </summary>
        [EdmScalarPropertyAttribute(EntityKeyProperty=true, IsNullable=false)]
        [DataMemberAttribute()]
        public global::System.Int32 pack_received
        {
            get
            {
                return _pack_received;
            }
            set
            {
                if (_pack_received != value)
                {
                    Onpack_receivedChanging(value);
                    ReportPropertyChanging("pack_received");
                    _pack_received = StructuralObject.SetValidValue(value);
                    ReportPropertyChanged("pack_received");
                    Onpack_receivedChanged();
                }
            }
        }
        private global::System.Int32 _pack_received;
        partial void Onpack_receivedChanging(global::System.Int32 value);
        partial void Onpack_receivedChanged();
    
        /// <summary>
        /// No hay documentación de metadatos disponible.
        /// </summary>
        [EdmScalarPropertyAttribute(EntityKeyProperty=true, IsNullable=false)]
        [DataMemberAttribute()]
        public global::System.Int32 pack_sent
        {
            get
            {
                return _pack_sent;
            }
            set
            {
                if (_pack_sent != value)
                {
                    Onpack_sentChanging(value);
                    ReportPropertyChanging("pack_sent");
                    _pack_sent = StructuralObject.SetValidValue(value);
                    ReportPropertyChanged("pack_sent");
                    Onpack_sentChanged();
                }
            }
        }
        private global::System.Int32 _pack_sent;
        partial void Onpack_sentChanging(global::System.Int32 value);
        partial void Onpack_sentChanged();
    
        /// <summary>
        /// No hay documentación de metadatos disponible.
        /// </summary>
        [EdmScalarPropertyAttribute(EntityKeyProperty=true, IsNullable=false)]
        [DataMemberAttribute()]
        public global::System.Int32 connections
        {
            get
            {
                return _connections;
            }
            set
            {
                if (_connections != value)
                {
                    OnconnectionsChanging(value);
                    ReportPropertyChanging("connections");
                    _connections = StructuralObject.SetValidValue(value);
                    ReportPropertyChanged("connections");
                    OnconnectionsChanged();
                }
            }
        }
        private global::System.Int32 _connections;
        partial void OnconnectionsChanging(global::System.Int32 value);
        partial void OnconnectionsChanged();
    
        /// <summary>
        /// No hay documentación de metadatos disponible.
        /// </summary>
        [EdmScalarPropertyAttribute(EntityKeyProperty=true, IsNullable=false)]
        [DataMemberAttribute()]
        public global::System.Int32 pack_errors
        {
            get
            {
                return _pack_errors;
            }
            set
            {
                if (_pack_errors != value)
                {
                    Onpack_errorsChanging(value);
                    ReportPropertyChanging("pack_errors");
                    _pack_errors = StructuralObject.SetValidValue(value);
                    ReportPropertyChanged("pack_errors");
                    Onpack_errorsChanged();
                }
            }
        }
        private global::System.Int32 _pack_errors;
        partial void Onpack_errorsChanging(global::System.Int32 value);
        partial void Onpack_errorsChanged();
    
        /// <summary>
        /// No hay documentación de metadatos disponible.
        /// </summary>
        [EdmScalarPropertyAttribute(EntityKeyProperty=true, IsNullable=false)]
        [DataMemberAttribute()]
        public global::System.Int32 total_read
        {
            get
            {
                return _total_read;
            }
            set
            {
                if (_total_read != value)
                {
                    Ontotal_readChanging(value);
                    ReportPropertyChanging("total_read");
                    _total_read = StructuralObject.SetValidValue(value);
                    ReportPropertyChanged("total_read");
                    Ontotal_readChanged();
                }
            }
        }
        private global::System.Int32 _total_read;
        partial void Ontotal_readChanging(global::System.Int32 value);
        partial void Ontotal_readChanged();
    
        /// <summary>
        /// No hay documentación de metadatos disponible.
        /// </summary>
        [EdmScalarPropertyAttribute(EntityKeyProperty=true, IsNullable=false)]
        [DataMemberAttribute()]
        public global::System.Int32 total_write
        {
            get
            {
                return _total_write;
            }
            set
            {
                if (_total_write != value)
                {
                    Ontotal_writeChanging(value);
                    ReportPropertyChanging("total_write");
                    _total_write = StructuralObject.SetValidValue(value);
                    ReportPropertyChanged("total_write");
                    Ontotal_writeChanged();
                }
            }
        }
        private global::System.Int32 _total_write;
        partial void Ontotal_writeChanging(global::System.Int32 value);
        partial void Ontotal_writeChanged();
    
        /// <summary>
        /// No hay documentación de metadatos disponible.
        /// </summary>
        [EdmScalarPropertyAttribute(EntityKeyProperty=true, IsNullable=false)]
        [DataMemberAttribute()]
        public global::System.Int32 total_errors
        {
            get
            {
                return _total_errors;
            }
            set
            {
                if (_total_errors != value)
                {
                    Ontotal_errorsChanging(value);
                    ReportPropertyChanging("total_errors");
                    _total_errors = StructuralObject.SetValidValue(value);
                    ReportPropertyChanged("total_errors");
                    Ontotal_errorsChanged();
                }
            }
        }
        private global::System.Int32 _total_errors;
        partial void Ontotal_errorsChanging(global::System.Int32 value);
        partial void Ontotal_errorsChanged();

        #endregion
    
    }

    #endregion
    
}