select b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, date_format(r.CREATED_DATE,"%Y-%m-%d") CREATED_DATE
from USED_GOODS_BOARD b
inner join USED_GOODS_REPLY r
using(BOARD_ID)
where b.CREATED_DATE >= "2022-10-01" and b.CREATED_DATE < "2022-11-01"
order by r.CREATED_DATE, b.TITLE;