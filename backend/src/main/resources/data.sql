-- ITEMS
INSERT INTO public.items(item_type,bonus_agility,bonus_intellect,bonus_strength,item_name,required_class,required_level)
VALUES ('weapon',1,3,1,'zwykla rozdzka','mage',1);
INSERT INTO public.items(item_type,bonus_agility,bonus_intellect,bonus_strength,item_name,required_class,required_level)
VALUES ('weapon',1,1,3,'zwykly miecz','warrior',1);
INSERT INTO public.items(item_type,bonus_agility,bonus_intellect,bonus_strength,item_name,required_class,required_level)
VALUES ('weapon',3,1,1,'zwykly luk','archer',1);
INSERT INTO public.items(item_type,bonus_agility,bonus_intellect,bonus_strength,item_name,required_class,required_level)
VALUES ('armor',1,1,3,'zwykla zbroja','warrior',1);
INSERT INTO public.items(item_type,bonus_agility,bonus_intellect,bonus_strength,item_name,required_class,required_level)
VALUES ('armor',1,3,1,'zwykly plasz','mage',1);
INSERT INTO public.items(item_type,bonus_agility,bonus_intellect,bonus_strength,item_name,required_class,required_level)
VALUES ('armor',3,1,1,'zwykly kaftan','archer',1);
INSERT INTO public.items(item_type,bonus_agility,bonus_intellect,bonus_strength,item_name,required_class,required_level)
VALUES ('helmet',1,1,3,'zwykly helm','warrior',1);
INSERT INTO public.items(item_type,bonus_agility,bonus_intellect,bonus_strength,item_name,required_class,required_level)
VALUES ('helmet',1,3,1,'zwykly kapelusz','mage',1);
INSERT INTO public.items(item_type,bonus_agility,bonus_intellect,bonus_strength,item_name,required_class,required_level)
VALUES ('helmet',3,1,1,'zwykla czapka','archer',1);

-- EQUIPMENTS
INSERT INTO public.equipments (armor_id, helmet_id, weapon_id) values (5, 8, 1);

-- HEROES
INSERT INTO public.heroes (agility, equipment_id, exp, hero_name, intellect, level, needed_exp, strength, hero_class) values (1, 1, 0, 'test_mage1', 5, 1, 3, 1, 'mage');
