with TempResult as ( SELECT u.id,
                            u.name,
                            u.username,
                            u.phone,
                            GROUP_CONCAT(ur2.role) as roleIds,
                            u.user_type,
                            u.status,
                            u.changed_at
                     from tbl_user u
                              inner join (select ur.user, ur.role
                                          from tbl_roles r
                                                   join tbl_users_roles ur on r.id = ur.role) as ur2
                                         on u.id = ur2.user
                                             and ur2.role =2
                     group by u.id ), TempCount as ( SELECT count(id) as row_count from TempResult)
select * from TempResult,TempCount
