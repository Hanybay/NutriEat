-- Ingrédients
INSERT INTO Ingredient (name, category, quantity, unit, marque) VALUES
('Tomato', 'Vegetable', 20, 'kg', 'XYZ'),
('Cheese', 'Dairy', 15, 'units', 'ABC'),
('Chicken Breast', 'Meat', 10, 'kg', 'DEF'),
('Lettuce', 'Vegetable', 8, 'kg', 'GHI'),
('Pasta', 'Grain', 25, 'kg', 'JKL'),
('Beef', 'Meat', 12, 'kg', 'MNO'),
('Mushrooms', 'Vegetable', 7, 'kg', 'PQR'),
('Onion', 'Vegetable', 10, 'kg', 'STU'),
('Shrimp', 'Seafood', 18, 'kg', 'VWX'),
( 'Olives', 'Vegetable', 5, 'kg', 'YZA'),
( 'Pepperoni', 'Meat', 9, 'kg', 'BCD'),
( 'Spinach', 'Vegetable', 6, 'kg', 'EFG'),
( 'Salmon', 'Seafood', 11, 'kg', 'HIJ'),
( 'Rice', 'Grain', 30, 'kg', 'KLM'),
( 'Eggplant', 'Vegetable', 9, 'kg', 'NOP'),
( 'Bell Pepper', 'Vegetable', 12, 'kg', 'QRS'),
( 'Ham', 'Meat', 7, 'kg', 'TUV'),
( 'Cheddar', 'Dairy', 14, 'units', 'WXY'),
( 'Zucchini', 'Vegetable', 6, 'kg', 'ZAB'),
( 'Bacon', 'Meat', 8, 'kg', 'CDE'),
( 'Feta Cheese', 'Dairy', 10, 'units', 'FGH'),
( 'Broccoli', 'Vegetable', 9, 'kg', 'IJK'),
( 'Ground Beef', 'Meat', 15, 'kg', 'LMN'),
( 'Potato', 'Vegetable', 18, 'kg', 'OPQ'),
( 'Avocado', 'Fruit', 13, 'units', 'RST'),
( 'Turkey', 'Meat', 10, 'kg', 'UVW'),
( 'Cucumber', 'Vegetable', 8, 'kg', 'XYZ'),
( 'Pineapple', 'Fruit', 10, 'units', 'ABC'),
( 'Tofu', 'Vegetarian', 10, 'kg', 'DEF'),
( 'Corn', 'Vegetable', 15, 'kg', 'GHI');

-- Plats
INSERT INTO Dish ( name, description, price) VALUES
('Margherita Pizza', 'Classic Italian pizza with tomato and cheese', 12.99),
('Chicken Alfredo Pasta', 'Creamy pasta with chicken and Alfredo sauce', 15.50),
('Vegetable Salad', 'Fresh mix of vegetables with dressing', 8.75),
('Beef Burger', 'Juicy beef patty with lettuce, tomato, and cheese', 10.99),
('Shrimp Scampi', 'Garlic butter shrimp with pasta', 18.25),
('Salmon Fillet', 'Grilled salmon served with vegetables', 22.00),
('Cheese Omelette', 'Omelette filled with cheddar and vegetables', 9.50),
('Stuffed Bell Peppers', 'Bell peppers filled with ground beef and rice', 13.75),
('Chicken Caesar Salad', 'Grilled chicken on a bed of fresh lettuce and croutons', 11.25),
( 'Eggplant Parmesan', 'Baked eggplant with tomato sauce and cheese', 14.50);
INSERT INTO Transaction (ingredient_id, action, date)
VALUES
(1, 20, NOW()), -- Tomato
(2, 15, NOW()), -- Cheese
(3, 10, NOW()), -- Chicken Breast
(4, 8, NOW()),  -- Lettuce
(5, 25, NOW()), -- Pasta
(6, 12, NOW()), -- Beef
(7, 7, NOW()),  -- Mushrooms
(8, 10, NOW()), -- Onion
(9, 18, NOW()), -- Shrimp
(10, 5, NOW()), -- Olives
(11, 9, NOW()), -- Pepperoni
(12, 6, NOW()), -- Spinach
(13, 11, NOW()), -- Salmon
(14, 30, NOW()), -- Rice
(15, 9, NOW()), -- Eggplant
(16, 12, NOW()), -- Bell Pepper
(17, 7, NOW()), -- Ham
(18, 14, NOW()), -- Cheddar
(19, 6, NOW()), -- Zucchini
(20, 8, NOW()), -- Bacon
(21, 10, NOW()), -- Feta Cheese
(22, 9, NOW()), -- Broccoli
(23, 15, NOW()), -- Ground Beef
(24, 18, NOW()), -- Potato
(25, 13, NOW()), -- Avocado
(26, 10, NOW()), -- Turkey
(27, 8, NOW()), -- Cucumber
(28, 10, NOW()), -- Pineapple
(29, 10, NOW()), -- Tofu
(30, 15, NOW()); -- Corn
INSERT INTO Dish_Ingredient ( ingredient_id, plat_id, quantite,unite) VALUES
(1, 1, 10,100),
(5, 1, 50,100),
(2, 1, 10,100),
(4, 1, 10,100),
(8, 1, 10,100);