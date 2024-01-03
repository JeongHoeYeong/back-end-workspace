-- 실습문제 1. ----------------------------------------------------------
SELECT country, city, address, district, first_name, last_name
FROM country
JOIN city USING (country_id)
JOIN address USING (city_id)
JOIN customer USING (address_id)
WHERE first_name='TRACY';

-- 실습문제 2. -------------------------------------------------------
SELECT first_name, last_name, title
FROM film
JOIN film_actor USING (film_id)
JOIN actor USING (actor_id)
WHERE concat(first_name,' ', last_name) = 'JULIA MCQUEEN'
ORDER BY title
limit 10;

-- 실습문제 3. -------------------------------------------------------
SELECT first_name, last_name
FROM film
JOIN film_actor USING (film_id)
JOIN actor USING (actor_id)
WHERE title = 'NOON PAPI';

-- 실습문제 4. -------------------------------------------------------
SELECT name as category, count(*) as count
FROM category
JOIN film_category USING (category_id)
JOIN inventory USING (film_id)
JOIN rental USING (inventory_id)
JOIN customer USING (customer_id)
WHERE email = 'JOYCE.EDWARDS@sakilacustomer.org'
GROUP BY name;
-- 실습문제 5. -------------------------------------------------------
SELECT title, description
FROM rental
JOIN customer USING (customer_id)
JOIN inventory USING (inventory_id)
JOIN film USING (film_id)
WHERE email IN (SELECT email
				FROM customer
				WHERE email = 'JOYCE.EDWARDS@sakilacustomer.org')
ORDER BY rental_date desc
limit 1;


