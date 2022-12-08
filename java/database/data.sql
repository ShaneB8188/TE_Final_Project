BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT into topping (name,price,isPremium,isAvailable) VALUES ('Extra Cheese',1,false,true);
INSERT into topping (name,price,isPremium,isAvailable) VALUES ('Pepperoni',1,false,true);
INSERT into topping (name,price,isPremium,isAvailable) VALUES ('Basil',1,false,true);
INSERT into topping (name,price,isPremium,isAvailable) VALUES ('Black Olives',1,false,true);
INSERT into topping (name,price,isPremium,isAvailable) VALUES ('Sausage',1,false,true);
INSERT into topping (name,price,isPremium,isAvailable) VALUES ('Ham',1,false,true);
INSERT into topping (name,price,isPremium,isAvailable) VALUES ('Banana Peppers',1,false,true);


COMMIT TRANSACTION;
