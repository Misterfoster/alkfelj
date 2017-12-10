/*get recipes by ingredients*/

SELECT r.id, r.name as recipe_name, r.directions, r.preptime, r.cooktime, u.username as recipe_by from ingredients i, rec_ing ri, recipes r, users u
where 1=1
and u.id = r.owner_id
and ri.rec_id = r.id
and ri.ing_id = i.id
and r.id in (select r.id from ingredients i, rec_ing ri, recipes r where 1=1
and i.name like'%%' and ri.rec_id = r.id and ri.ing_id = i.id)
group by r.name