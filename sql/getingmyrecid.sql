/* get ingredients by recipe id*/
select  i.name, ri.amount, ri.unit  from ingredients i, recipes r, rec_ing ri where ri.rec_id=r.id and ri.ing_id=i.id and r.id=1