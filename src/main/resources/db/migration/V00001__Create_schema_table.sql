create SCHEMA IF NOT EXISTS db_beatdev;
use db_beatdev;

create TABLE IF NOT EXISTS users (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(40) NOT NULL,
  state VARCHAR(20) NOT NULL,
  email VARCHAR(50) NOT NULL);

  create TABLE IF NOT EXISTS avatars (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  PRIMARY KEY (id));

create TABLE IF NOT EXISTS user_avatars(
    user_id BIGINT NOT NULL PRIMARY KEY,
    avatar_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
    ON delete CASCADE
    ON update CASCADE,
    CONSTRAINT avatar_id
    FOREIGN KEY (avatar_id)
    REFERENCES avatars (id)
    ON delete CASCADE
    ON update CASCADE
);
