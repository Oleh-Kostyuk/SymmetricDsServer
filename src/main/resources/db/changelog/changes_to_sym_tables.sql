
insert into sym_node_group (node_group_id) values ('server');
insert into sym_node_group (node_group_id) values ('store');

insert into sym_node_group_link (source_node_group_id, target_node_group_id, data_event_action) values ('corp', 'store', 'W');
insert into sym_node_group_link (source_node_group_id, target_node_group_id, data_event_action) values ('store', 'corp', 'P');
