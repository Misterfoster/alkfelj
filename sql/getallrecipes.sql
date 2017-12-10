/*all recipes*/
SELECT r.id, r.name as recipe_name, r.directions, r.preptime, r.cooktime, u.username as recipe_by from ingredients i, rec_ing ri, recipes r, users u
where 1=1
and u.id = r.owner_id
and ri.rec_id = r.id
and ri.ing_id = i.id
group by r.name