DROP TABLE IF EXISTS elastic_menu;
CREATE TABLE elastic_menu (
  id varchar(64) NOT NULL,
  code varchar(255) DEFAULT NULL COMMENT '菜单编码',
  p_code varchar(255) DEFAULT NULL COMMENT '菜单父编码',
  p_id varchar(255) DEFAULT NULL COMMENT '父菜单ID',
  name varchar(255) DEFAULT NULL COMMENT '名称',
  url varchar(255) DEFAULT NULL COMMENT '请求地址',
  is_menu int(11) DEFAULT NULL COMMENT '是否是菜单',
  level int(11) DEFAULT NULL COMMENT '菜单层级',
  sort int(11) DEFAULT NULL COMMENT '菜单排序',
  status int(11) DEFAULT NULL,
  icon varchar(255) DEFAULT NULL,
  create_time datetime DEFAULT NULL,
  update_time datetime DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY FK_CODE (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO elastic_menu VALUES ('00', 'root', '0', '0', '系统根目录', '', '1', '0', '1', '1', null, now(), null);
INSERT INTO elastic_menu VALUES ('01', 'system', 'root', '00', '系统设置', 'system', '1', '1', '10', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('0101', 'userList', 'system', '01', '用户管理', 'user/list', '1', '2', '1', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('010101', 'user/add', 'userList', '0101', '用户添加', 'user/add', '0', '3', '1', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('010102', 'user/edit', 'userList', '0101', '用户修改', 'user/edit', '0', '3', '1', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('010103', 'user/view', 'userList', '0101', '用户查看', 'user/View', '0', '3', '2', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('010104', 'user/delete', 'userList', '0101', '用户删除', 'user/delete', '0', '3', '4', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('010105', '/user/modify', 'userList', '0101', '密码重置', '/user/modify', '1', '3', '2', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('0102', 'roleList', 'system', '01', '角色管理', 'role/list', '1', '2', '2', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('010201', 'role/add', 'roleList', '0102', '角色添加', 'role/add', '0', '3', '1', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('010202', 'role/edit', 'roleList', '0102', '角色编辑', 'role/edit', '0', '3', '2', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('010203', 'role/delete', 'roleList', '0102', '角色删除', 'role/delete', '0', '3', '2', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('010204', 'role/permission', 'roleList', '0102', '角色配权', 'role/permission', '0', '3', '3', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('0103', 'menu/list', 'system', '01', '菜单管理', 'menu/list', '1', '2', '2', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('010301', 'menu/add', 'menu/list', '0103', '菜单添加', 'menu/add', '0', '3', '1', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('010302', 'menu/edit', 'menu/list', '0103', '菜单编辑', 'menu/edit', '0', '3', '2', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('010303', 'menu/delete', 'menu/list', '0103', '菜单删除', 'menu/delete', '0', '3', '2', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('0104', 'apidoc', 'system', '01', 'Api文档', 'swagger-ui.html', '1', '2', '9', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('0105', 'database/log', 'system', '01', '数据库日志', 'druid', '1', '2', '10', '1', '', now(), null);
INSERT INTO elastic_menu VALUES ('02', 'companyList', 'root', '00', '公司管理', 'companyList', '1', '1', '1', '1', '', now(), null);


DROP TABLE IF EXISTS elastic_role_menu;
CREATE TABLE elastic_role_menu (
  role_id int(11) DEFAULT NULL,
  menu_id varchar(255) DEFAULT NULL,
  create_time datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO elastic_role_menu VALUES ('6', '01', now());
INSERT INTO elastic_role_menu VALUES ('6', '0101', now());
INSERT INTO elastic_role_menu VALUES ('6', '010102', now());
INSERT INTO elastic_role_menu VALUES ('6', '0104', now());
INSERT INTO elastic_role_menu VALUES ('6', '01', now());
INSERT INTO elastic_role_menu VALUES ('6', '0101', now());
INSERT INTO elastic_role_menu VALUES ('6', '010102', now());
INSERT INTO elastic_role_menu VALUES ('6', '0104', now());
INSERT INTO elastic_role_menu VALUES ('6', '0105', now());
INSERT INTO elastic_role_menu VALUES ('6', '01', now());
INSERT INTO elastic_role_menu VALUES ('6', '0101', now());
INSERT INTO elastic_role_menu VALUES ('6', '010102', now());
INSERT INTO elastic_role_menu VALUES ('6', '010103', now());
INSERT INTO elastic_role_menu VALUES ('6', '0104', now());
INSERT INTO elastic_role_menu VALUES ('6', '0105', now());
INSERT INTO elastic_role_menu VALUES ('6', '01', now());
INSERT INTO elastic_role_menu VALUES ('6', '0101', now());
INSERT INTO elastic_role_menu VALUES ('6', '010102', now());
INSERT INTO elastic_role_menu VALUES ('6', '010103', now());
INSERT INTO elastic_role_menu VALUES ('6', '010104', now());
INSERT INTO elastic_role_menu VALUES ('6', '0104', now());
INSERT INTO elastic_role_menu VALUES ('6', '0105', now());
INSERT INTO elastic_role_menu VALUES ('6', '01', now());
INSERT INTO elastic_role_menu VALUES ('6', '0101', now());
INSERT INTO elastic_role_menu VALUES ('6', '010101', now());
INSERT INTO elastic_role_menu VALUES ('6', '010102', now());
INSERT INTO elastic_role_menu VALUES ('6', '010103', now());
INSERT INTO elastic_role_menu VALUES ('6', '010104', now());
INSERT INTO elastic_role_menu VALUES ('6', '0104', now());
INSERT INTO elastic_role_menu VALUES ('6', '0105', now());
INSERT INTO elastic_role_menu VALUES ('8', '01', now());
INSERT INTO elastic_role_menu VALUES ('8', '0101', now());
INSERT INTO elastic_role_menu VALUES ('8', '010101', now());
INSERT INTO elastic_role_menu VALUES ('8', '010102', now());
INSERT INTO elastic_role_menu VALUES ('8', '010103', now());
INSERT INTO elastic_role_menu VALUES ('8', '010104', now());
INSERT INTO elastic_role_menu VALUES ('8', '0102', now());
INSERT INTO elastic_role_menu VALUES ('8', '010201', now());
INSERT INTO elastic_role_menu VALUES ('8', '010202', now());
INSERT INTO elastic_role_menu VALUES ('8', '010203', now());
INSERT INTO elastic_role_menu VALUES ('8', '010204', now());
INSERT INTO elastic_role_menu VALUES ('8', '0103', now());
INSERT INTO elastic_role_menu VALUES ('8', '010301', now());
INSERT INTO elastic_role_menu VALUES ('8', '010302', now());
INSERT INTO elastic_role_menu VALUES ('8', '010303', now());
INSERT INTO elastic_role_menu VALUES ('8', '0104', now());
INSERT INTO elastic_role_menu VALUES ('8', '0105', now());
INSERT INTO elastic_role_menu VALUES ('8', '02', now());
INSERT INTO elastic_role_menu VALUES ('8', '894769217763540992', now());
INSERT INTO elastic_role_menu VALUES ('17', '01', now());
INSERT INTO elastic_role_menu VALUES ('17', '0105', now());
INSERT INTO elastic_role_menu VALUES ('17', '02', now());
INSERT INTO elastic_role_menu VALUES ('17', '894769217763540992', now());


DROP TABLE IF EXISTS elastic_role;
CREATE TABLE elastic_role (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  value varchar(255) DEFAULT NULL,
  tips varchar(255) DEFAULT NULL,
  create_time datetime DEFAULT NULL,
  update_time datetime DEFAULT NULL,
  status int(11) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY unique_role_name (name),
  UNIQUE KEY unique_role_value (value)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

INSERT INTO elastic_role VALUES ('6', '管理员', 'admin', null, now(), now(), '1');
INSERT INTO elastic_role VALUES ('8', '超级管理员', 'super', null, now(), null, '1');
INSERT INTO elastic_role VALUES ('17', '用户', 'user', null, now(), now(), '1');


DROP TABLE IF EXISTS elastic_user;
CREATE TABLE elastic_user (
  id int(11) NOT NULL AUTO_INCREMENT,
  avatar varchar(255) DEFAULT NULL,
  username varchar(45) DEFAULT NULL,
  password varchar(45) DEFAULT NULL,
  salt varchar(45) DEFAULT NULL,
  name varchar(45) DEFAULT NULL,
  birthday datetime DEFAULT NULL,
  sex int(11) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  phone varchar(45) DEFAULT NULL,
  status int(11) DEFAULT NULL,
  create_time datetime DEFAULT NULL,
  update_time datetime DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY unique_user_username (username)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

INSERT INTO elastic_user VALUES ('46', null, 'super', 'a5322b1321d2c849e22fa3f62bf87d6b', 'u2w3z', '超级管理员', null, '1', null, null, '1', now(), null);
INSERT INTO elastic_user VALUES ('48', null, 'admin', '439b9b33eb18d644f3b57e182f45b86a', 'bycca', '管理员', null, '1', null, null, '1', now(), null);
INSERT INTO elastic_user VALUES ('49', null, 'yangxiufeng', '51d69a1a145c293eedb25e90378a0985', 'hm8ow', '秀秀2', null, '1', null, null, '1', now(), null);
INSERT INTO elastic_user VALUES ('50', null, 'test', 'add119aedb346d8b58eb4955072344e9', 'xkbjg', '测试用户', null, '1', null, null, '1', now(), null);
INSERT INTO elastic_user VALUES ('58', null, 'ces1', '19f33490ae4e4732b299d54f9e8f0253', 'rxkuh', 'da', null, '1', null, null, '1', now(), null);



DROP TABLE IF EXISTS elastic_user_role;
CREATE TABLE elastic_user_role (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) DEFAULT NULL,
  role_id int(11) DEFAULT NULL,
  create_time datetime DEFAULT NULL,
  create_by varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

INSERT INTO elastic_user_role VALUES ('1', '46', '8', now(), null);
INSERT INTO elastic_user_role VALUES ('2', '48', '6', now(), null);
INSERT INTO elastic_user_role VALUES ('3', '49', '17', now(), null);
INSERT INTO elastic_user_role VALUES ('19', '50', '6', now(), '超级管理员');
INSERT INTO elastic_user_role VALUES ('20', '50', '17', now(), '超级管理员');



DROP TABLE IF EXISTS elastic_dept;
CREATE TABLE elastic_dept (
  id int(11) NOT NULL AUTO_INCREMENT,
  num int(11) DEFAULT NULL,
  pid int(11) DEFAULT NULL,
  simple_name varchar(45) DEFAULT NULL,
  full_name varchar(255) DEFAULT NULL,
  tips varchar(255) DEFAULT NULL,
  version int(11) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

INSERT INTO elastic_dept VALUES ('34', null, '0', '总公司', '总公司', null, null);
INSERT INTO elastic_dept VALUES ('35', null, '34', '技术部', '技术部', null, null);
INSERT INTO elastic_dept VALUES ('36', null, '34', '运营部', '运营部', null, null);
INSERT INTO elastic_dept VALUES ('37', null, '34', '招商部', '招商部', null, null);

DROP TABLE IF EXISTS elastic_user_dept;
CREATE TABLE elastic_user_dept (
  user_id int(11) DEFAULT NULL,
  dept_id int(11) DEFAULT NULL,
  create_time datetime DEFAULT NULL,
  create_by varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS elastic_notice;
CREATE TABLE elastic_notice (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '序列',
  title varchar(255) DEFAULT NULL COMMENT '标题',
  type int(11) DEFAULT NULL COMMENT '类型',
  content text COMMENT '内容',
  create_time datetime DEFAULT NULL COMMENT '创建时间',
  creator int(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS elastic_operation_log;
CREATE TABLE elastic_operation_log (
  id varchar(36) NOT NULL,
  user_id int(11) DEFAULT NULL COMMENT '操作人ID',
  username varchar(255) DEFAULT NULL COMMENT '操作人姓名',
  class_name varchar(255) DEFAULT NULL COMMENT '被操作类',
  method varchar(255) DEFAULT NULL COMMENT '方法',
  args varchar(255) DEFAULT NULL COMMENT '参数',
  origin_data text COMMENT '原始数据',
  new_data text COMMENT '新数据',
  create_time datetime DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS elastic_login_log;
CREATE TABLE elastic_login_log (
  id int(11) NOT NULL AUTO_INCREMENT,
  log_name varchar(255) DEFAULT NULL,
  user_id int(65) DEFAULT NULL,
  create_time datetime DEFAULT NULL,
  succeed varchar(255) DEFAULT NULL,
  message text,
  ip varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;