
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Événements éducatifs et professionnels', 'Conférences');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Événements musicaux et artistiques', 'Concerts');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Événements sportifs et compétitions', 'Sports');


-- Assuming you already have a sequence named 'product_seq'

-- Insert products for the 'Keyboards' category
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES
    -- 🎤 Conférences
    (nextval('product_seq'), 20, 'Séminaire sur le développement personnel et la réussite', 'Personal Development Seminar', 50.00, (SELECT id FROM category WHERE name = 'Conférences')),
    (nextval('product_seq'), 15, 'Atelier de leadership et communication efficace', 'Leadership & Communication Workshop', 40.00, (SELECT id FROM category WHERE name = 'Conférences')),
    (nextval('product_seq'), 30, 'Conférence sur les tendances technologiques du futur', 'Future Tech Conference', 75.00, (SELECT id FROM category WHERE name = 'Conférences')),
    (nextval('product_seq'), 25, 'Table ronde sur lintelligence artificielle et lemploi', 'AI & Jobs Roundtable', 45.00, (SELECT id FROM category WHERE name = 'Conférences')),
    (nextval('product_seq'), 18, 'Forum sur les innovations en blockchain et cryptomonnaies', 'Blockchain Innovations Forum', 55.00, (SELECT id FROM category WHERE name = 'Conférences'))
    ;

-- Insert products for the 'Monitors' category
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES
    -- 🎶 Concerts
    (nextval('product_seq'), 2, 'Concert live du groupe de rock légendaire', 'Rock Legends Live', 80.00, (SELECT id FROM category WHERE name = 'Concerts')),
    (nextval('product_seq'), 30, 'Festival de musique électro en plein air', 'Electronic Music Festival', 120.00, (SELECT id FROM category WHERE name = 'Concerts')),
    (nextval('product_seq'), 20, 'Concert symphonique sous les étoiles', 'Symphony Under the Stars', 60.00, (SELECT id FROM category WHERE name = 'Concerts')),
    (nextval('product_seq'), 35, 'Rap & Hip-Hop Festival avec des artistes internationaux', 'Rap & Hip-Hop Festival', 90.00, (SELECT id FROM category WHERE name = 'Concerts')),
    (nextval('product_seq'), 45, 'Spectacle musical hommage aux années 80', '80s Tribute Show', 50.00, (SELECT id FROM category WHERE name = 'Concerts'));

-- Insert products for the 'Screens' category
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES
    -- ⚽ Sports
    (nextval('product_seq'), 600, 'Match de football de championnat national', 'National Football Match', 40.00, (SELECT id FROM category WHERE name = 'Sports')),
    (nextval('product_seq'), 150, 'Tournoi international de basketball', 'International Basketball Tournament', 55.00, (SELECT id FROM category WHERE name = 'Sports')),
    (nextval('product_seq'), 200, 'Grand Prix de Formule 1', 'Formula 1 Grand Prix', 250.00, (SELECT id FROM category WHERE name = 'Sports')),
    (nextval('product_seq'), 100, 'Finale du championnat de tennis', 'Tennis Championship Final', 100.00, (SELECT id FROM category WHERE name = 'Sports')),
    (nextval('product_seq'), 300, 'Compétition de marathon en ville', 'City Marathon', 20.00, (SELECT id FROM category WHERE name = 'Sports'));