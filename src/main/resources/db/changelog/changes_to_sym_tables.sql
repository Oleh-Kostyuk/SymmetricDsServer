
delete from sym_trigger_router;
delete from sym_trigger;
delete from sym_router;
delete from sym_node_group_link;
delete from sym_node_group;
delete from sym_node_host;
delete from sym_node_identity;
delete from sym_node_security;
delete from sym_node;
delete from sym_channel where channel_id in ('orders');

insert into sym_channel
(channel_id, processing_order, max_batch_size, enabled, description)
values('orders', 1, 100000, 1, 'channel to transfer information from  store department');
------------------------------------------------------------------------------
-- Node Groups
------------------------------------------------------------------------------
insert into sym_node_group (node_group_id, description) values ('server', 'the main  corporate node');
insert into sym_node_group ( node_group_id, description) values ('store', 'A remote store node');
-----------------------------------------------------------------------------
-- Node Group Links
------------------------------------------------------------------------------
insert into sym_node_group_link (source_node_group_id, target_node_group_id, data_event_action) values ('server', 'store', 'W');
insert into sym_node_group_link (source_node_group_id, target_node_group_id, data_event_action) values ('store', 'server', 'P');
-----------------------------------------------------------------------------
-- Triggers
------------------------------------------------------------------------------

-- Triggers for tables on "orders" channel
insert into sym_trigger
(trigger_id,source_table_name,channel_id,last_update_time,create_time)
values('providers','providers','orders',current_timestamp,current_timestamp);

insert into sym_trigger
(trigger_id,source_table_name,channel_id,last_update_time,create_time)
values('orders','orders','orders',current_timestamp,current_timestamp);

insert into sym_trigger
(trigger_id,source_table_name,channel_id,last_update_time,create_time)
values('typeRwm','type_of_raw_materials','orders',current_timestamp,current_timestamp);

insert into sym_trigger
(trigger_id,source_table_name,channel_id,last_update_time,create_time)
values('kindRwm','kind_of_raw_materials','orders',current_timestamp,current_timestamp);

-- Routers
------------------------------------------------------------------------------

-- Default router sends all data from server to store
insert into sym_router
(router_id,source_node_group_id,target_node_group_id,router_type,create_time,last_update_time)
values('server_2_store', 'server', 'store', 'default',current_timestamp, current_timestamp);

-- Default router sends all data from store to corp
insert into sym_router
(router_id,source_node_group_id,target_node_group_id,router_type,create_time,last_update_time)
values('store_2_server', 'store', 'server', 'default',current_timestamp, current_timestamp);

--Trigger Routers
------------------------------------------------------------------------------

-- Send providers to store
insert into sym_trigger_router
(trigger_id,router_id,initial_load_order,last_update_time,create_time)
values('providers','server_2_store', 1, current_timestamp, current_timestamp);

insert into sym_trigger_router
(trigger_id,router_id,initial_load_order,last_update_time,create_time)
values('kindRwm','server_2_store', 1, current_timestamp, current_timestamp);

insert into sym_trigger_router
(trigger_id,router_id,initial_load_order,last_update_time,create_time)
values('typeRwm','server_2_store', 1, current_timestamp, current_timestamp);


-- Send all sales transactions to server
insert into sym_trigger_router
(trigger_id,router_id,initial_load_order,last_update_time,create_time)
values('orders','store_2_server', 1, current_timestamp, current_timestamp);





