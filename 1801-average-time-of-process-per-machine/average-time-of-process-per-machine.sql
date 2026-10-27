# Write your MySQL query statement below
SELECT
    ans.machine_id,
    ROUND(SUM(ans.diff) / COUNT(ans.process_id), 3) AS processing_time
FROM (
    SELECT
        a1.machine_id,
        a1.process_id,
        (a2.timestamp - a1.timestamp) AS diff
    FROM Activity a1
    JOIN Activity a2
        ON a1.machine_id = a2.machine_id
        AND a1.process_id = a2.process_id
        AND a1.activity_type = 'start'
        AND a2.activity_type = 'end'
) AS ans
GROUP BY ans.machine_id;