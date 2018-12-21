-- create table?

insert into user (username, password, name, role) values ('admin', 'password', 'Admin', ROLE_ADMIN);
insert into user (username, password, name, role) values ('johndoe', 'password', 'John Doe', ROLE_USER);

insert into recipe (user_id, name, picture) values (1, 'Pizza Moons', 'pizza_moons.jpg');
insert into recipe (user_id, name, picture) values (1, 'Quick and Easy Brownies', 'brownies.jpg');
insert into recipe (user_id, name, picture) values (2, '3-Ingredient Peanut Butter Cookies', 'cookie.jpg');

insert into ingredient (name, unit) values ('refrigerated crescent rolls', 'ounce');
insert into ingredient (name, unit) values ('shredded mozzarella cheese', 'cup');
insert into ingredient (name, unit) values ('pepperoni', 'slice');
insert into ingredient (name, unit) values ('Parmesan cheese', 'cup');
insert into ingredient (name, unit) values ('white sugar', 'cup');
insert into ingredient (name, unit) values ('butter', 'cup');
insert into ingredient (name, unit) values ('cocoa powder', 'cup');
insert into ingredient (name, unit) values ('vanilla extract', 'teaspoon');
insert into ingredient (name, unit) values ('egg', null);
insert into ingredient (name, unit) values ('all-purpose flour', 'cup');
insert into ingredient (name, unit) values ('baking powder', 'teaspoon');
insert into ingredient (name, unit) values ('salt', 'teaspoon');
insert into ingredient (name, unit) values ('walnut halves', 'cup');
insert into ingredient (name, unit) values ('peanut butter', 'cup');

insert into quantity (recipe_id, ingredient_id, quantity) values (1, 1, 8);
insert into quantity (recipe_id, ingredient_id, quantity) values (1, 2, 4);
insert into quantity (recipe_id, ingredient_id, quantity) values (1, 3, 16);
insert into quantity (recipe_id, ingredient_id, quantity) values (1, 4, 0.5);
insert into quantity (recipe_id, ingredient_id, quantity) values (2, 5, 2);
insert into quantity (recipe_id, ingredient_id, quantity) values (2, 6, 1);
insert into quantity (recipe_id, ingredient_id, quantity) values (2, 7, 0.5);
insert into quantity (recipe_id, ingredient_id, quantity) values (2, 8, 1);
insert into quantity (recipe_id, ingredient_id, quantity) values (2, 9, 4);
insert into quantity (recipe_id, ingredient_id, quantity) values (2, 10, 1.5);
insert into quantity (recipe_id, ingredient_id, quantity) values (2, 11, 0.5);
insert into quantity (recipe_id, ingredient_id, quantity) values (2, 12, 0.5);
insert into quantity (recipe_id, ingredient_id, quantity) values (2, 13, 0.5);
insert into quantity (recipe_id, ingredient_id, quantity) values (3, 14, 1);
insert into quantity (recipe_id, ingredient_id, quantity) values (3, 5, 1);
insert into quantity (recipe_id, ingredient_id, quantity) values (3, 9, 1);

insert into instruction (recipe_id, step, description) values (1, 1, 'Preheat an oven to 375 degrees F (190 degrees C).');
insert into instruction (recipe_id, step, description) values (1, 2, 'Unroll crescents onto work surface. Top each piece of dough with shredded cheese and a few slices of pepperoni. Sprinkle on a bit more cheese, and roll into crescent shape. Place pizza "moons" on a baking sheet.');
insert into instruction (recipe_id, step, description) values (1, 3, 'Bake until crescents are golden brown, 12 to 15 minutes. Remove from oven, and sprinkle with Parmesan cheese.');
insert into instruction (recipe_id, step, description) values (2, 1, 'Melt the butter or margarine and mix all ingredients in the order given.');
insert into instruction (recipe_id, step, description) values (2, 2, 'Bake at 350 degrees F (175 degrees C) for 20 to 30 minutes in a 9 x 13 inch greased pan.');
insert into instruction (recipe_id, step, description) values (3, 1, 'Preheat oven to 350 degrees F (175 degrees C).');
insert into instruction (recipe_id, step, description) values (3, 2, 'Mix peanut butter, sugar, and egg together in a bowl using an electric mixer until smooth and creamy. Roll mixture into small balls and arrange on a baking sheet; flatten each with a fork, making a criss-cross pattern.');
insert into instruction (recipe_id, step, description) values (3, 3, 'Bake in the preheated oven for 10 minutes. Cool cookies on the baking sheet for 2 minutes before moving to a plate.');
