CREATE TABLE RM_ENVIRONMENT(
  ID INTEGER NOT NULL,
  NAME VARCHAR(128) NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE (NAME)
);

CREATE TABLE RM_SERVER_INSTANCE (
  ID INTEGER NOT NULL,
  ENVIRONMENT_ID INTEGER NOT NULL,
  NAME VARCHAR(128) NOT NULL,
  SERVER_URL VARCHAR(1024) NOT NULL,
  DBMS_TYPE VARCHAR(128) NOT NULL,
  INSTANCE_TYPE VARCHAR(128) NOT NULL,
  SERVER_CATEGORY VARCHAR(128) NOT NULL,
  ADMIN_USERNAME VARCHAR(128),
  ADMIN_PASSWORD VARCHAR(128),
  TENANT_ID INTEGER NOT NULL,
  UNIQUE (NAME, ENVIRONMENT_ID, TENANT_ID),
  PRIMARY KEY (ID),
  FOREIGN KEY (ENVIRONMENT_ID) REFERENCES RM_ENVIRONMENT (ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE RM_DATABASE (
  ID INTEGER NOT NULL,
  NAME VARCHAR(128) NOT NULL,
  RSS_INSTANCE_ID INTEGER NOT NULL,
  TYPE VARCHAR(15) NOT NULL,
  TENANT_ID INTEGER NOT NULL,
  UNIQUE (NAME, RSS_INSTANCE_ID, TENANT_ID),
  PRIMARY KEY (ID),
  FOREIGN KEY (RSS_INSTANCE_ID) REFERENCES RM_SERVER_INSTANCE (ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE RM_DATABASE_USER (
  ID INTEGER NOT NULL,
  USERNAME VARCHAR(16) NOT NULL,
  ENVIRONMENT_ID INTEGER NOT NULL,
  TYPE VARCHAR(15) NOT NULL,
  TENANT_ID INTEGER NOT NULL,
  UNIQUE (USERNAME, TENANT_ID, ENVIRONMENT_ID),
  PRIMARY KEY (ID)
);

CREATE TABLE RM_USER_DATABASE_ENTRY (
  ID INTEGER NOT NULL,
  DATABASE_USER_ID INTEGER NOT NULL,
  DATABASE_ID INTEGER NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE (DATABASE_USER_ID, DATABASE_ID),
  FOREIGN KEY (DATABASE_USER_ID) REFERENCES RM_DATABASE_USER (ID) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (DATABASE_ID) REFERENCES RM_DATABASE (ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE RM_USER_DATABASE_PRIVILEGE (
  ID INTEGER NOT NULL,
  USER_DATABASE_ENTRY_ID INTEGER NOT NULL,
  SELECT_PRIV CHAR(1) NOT NULL CHECK (SELECT_PRIV IN('N','Y')),
  INSERT_PRIV CHAR(1) NOT NULL CHECK (INSERT_PRIV IN('N','Y')),
  UPDATE_PRIV CHAR(1) NOT NULL CHECK (UPDATE_PRIV IN('N','Y')),
  DELETE_PRIV CHAR(1) NOT NULL CHECK (DELETE_PRIV IN('N','Y')),
  CREATE_PRIV CHAR(1) NOT NULL CHECK (CREATE_PRIV IN('N','Y')),
  DROP_PRIV CHAR(1) NOT NULL CHECK (DROP_PRIV IN('N','Y')),
  GRANT_PRIV CHAR(1) NOT NULL CHECK (GRANT_PRIV IN('N','Y')),
  REFERENCES_PRIV CHAR(1) NOT NULL CHECK (REFERENCES_PRIV IN('N','Y')),
  INDEX_PRIV CHAR(1) NOT NULL CHECK (INDEX_PRIV IN('N','Y')),
  ALTER_PRIV CHAR(1) NOT NULL CHECK (ALTER_PRIV IN('N','Y')),
  CREATE_TMP_TABLE_PRIV CHAR(1) NOT NULL CHECK (CREATE_TMP_TABLE_PRIV IN('N','Y')),
  LOCK_TABLES_PRIV CHAR(1) NOT NULL CHECK (LOCK_TABLES_PRIV IN('N','Y')),
  CREATE_VIEW_PRIV CHAR(1) NOT NULL CHECK (CREATE_VIEW_PRIV IN('N','Y')),
  SHOW_VIEW_PRIV CHAR(1) NOT NULL CHECK (SHOW_VIEW_PRIV IN('N','Y')),
  CREATE_ROUTINE_PRIV CHAR(1) NOT NULL CHECK (CREATE_ROUTINE_PRIV IN('N','Y')),
  ALTER_ROUTINE_PRIV CHAR(1) NOT NULL CHECK (ALTER_ROUTINE_PRIV IN('N','Y')),
  EXECUTE_PRIV CHAR(1) NOT NULL CHECK (EXECUTE_PRIV IN('N','Y')),
  EVENT_PRIV CHAR(1) NOT NULL CHECK (EVENT_PRIV IN('N','Y')),
  TRIGGER_PRIV CHAR(1) NOT NULL CHECK (TRIGGER_PRIV IN('N','Y')),
  PRIMARY KEY (ID),
  UNIQUE (USER_DATABASE_ENTRY_ID),
  FOREIGN KEY (USER_DATABASE_ENTRY_ID) REFERENCES RM_USER_DATABASE_ENTRY (ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE RM_SYSTEM_DATABASE_COUNT (
  ID INTEGER NOT NULL,
  ENVIRONMENT_ID INTEGER NOT NULL,
  COUNT INTEGER NOT NULL DEFAULT 0,
  PRIMARY KEY (ID),
  FOREIGN KEY (ENVIRONMENT_ID) REFERENCES RM_ENVIRONMENT (ID)
);

CREATE TABLE RM_DB_PRIVILEGE_TEMPLATE (
  ID INTEGER NOT NULL,
  ENVIRONMENT_ID INTEGER NOT NULL,
  NAME VARCHAR(128) NOT NULL,
  TENANT_ID INTEGER NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE (ENVIRONMENT_ID, NAME, TENANT_ID),
  FOREIGN KEY (ENVIRONMENT_ID) REFERENCES RM_ENVIRONMENT (ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE RM_DB_PRIVILEGE_TEMPLATE_ENTRY (
  ID INTEGER NOT NULL,
  TEMPLATE_ID INTEGER NOT NULL,
  SELECT_PRIV CHAR(1) NOT NULL CHECK (SELECT_PRIV IN('N','Y')),
  INSERT_PRIV CHAR(1) NOT NULL CHECK (INSERT_PRIV IN('N','Y')),
  UPDATE_PRIV CHAR(1) NOT NULL CHECK (UPDATE_PRIV IN('N','Y')),
  DELETE_PRIV CHAR(1) NOT NULL CHECK (DELETE_PRIV IN('N','Y')),
  CREATE_PRIV CHAR(1) NOT NULL CHECK (CREATE_PRIV IN('N','Y')),
  DROP_PRIV CHAR(1) NOT NULL CHECK (DROP_PRIV IN('N','Y')),
  GRANT_PRIV CHAR(1) NOT NULL CHECK (GRANT_PRIV IN('N','Y')),
  REFERENCES_PRIV CHAR(1) NOT NULL CHECK (REFERENCES_PRIV IN('N','Y')),
  INDEX_PRIV CHAR(1) NOT NULL CHECK (INDEX_PRIV IN('N','Y')),
  ALTER_PRIV CHAR(1) NOT NULL CHECK (ALTER_PRIV IN('N','Y')),
  CREATE_TMP_TABLE_PRIV CHAR(1) NOT NULL CHECK (CREATE_TMP_TABLE_PRIV IN('N','Y')),
  LOCK_TABLES_PRIV CHAR(1) NOT NULL CHECK (LOCK_TABLES_PRIV IN('N','Y')),
  CREATE_VIEW_PRIV CHAR(1) NOT NULL CHECK (CREATE_VIEW_PRIV IN('N','Y')),
  SHOW_VIEW_PRIV CHAR(1) NOT NULL CHECK (SHOW_VIEW_PRIV IN('N','Y')),
  CREATE_ROUTINE_PRIV CHAR(1) NOT NULL CHECK (CREATE_ROUTINE_PRIV IN('N','Y')),
  ALTER_ROUTINE_PRIV CHAR(1) NOT NULL CHECK (ALTER_ROUTINE_PRIV IN('N','Y')),
  EXECUTE_PRIV CHAR(1) NOT NULL CHECK (EXECUTE_PRIV IN('N','Y')),
  EVENT_PRIV CHAR(1) NOT NULL CHECK (EVENT_PRIV IN('N','Y')),
  TRIGGER_PRIV CHAR(1) NOT NULL CHECK (TRIGGER_PRIV IN('N','Y')),
  PRIMARY KEY (ID),
  FOREIGN KEY (TEMPLATE_ID) REFERENCES RM_DB_PRIVILEGE_TEMPLATE (ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE RM_USER_INSTANCE_ENTRY (
 RSS_INSTANCE_ID INTEGER NOT NULL ,
 DATABASE_USER_ID INTEGER NOT NULL ,
 PRIMARY KEY (RSS_INSTANCE_ID,DATABASE_USER_ID) ,
 FOREIGN KEY (DATABASE_USER_ID) REFERENCES RM_DATABASE_USER (ID) ON DELETE CASCADE ON UPDATE CASCADE,
 FOREIGN KEY (RSS_INSTANCE_ID ) REFERENCES RM_SERVER_INSTANCE (ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE INDEX INDEX_RM_USER_INSTANCE_ENTRY_DATABASE_USER_ID ON RM_USER_INSTANCE_ENTRY(DATABASE_USER_ID);
CREATE INDEX INDEX_RM_USER_INSTANCE_ENTRY_RSS_INSTANCE_ID ON RM_USER_INSTANCE_ENTRY(RSS_INSTANCE_ID);
