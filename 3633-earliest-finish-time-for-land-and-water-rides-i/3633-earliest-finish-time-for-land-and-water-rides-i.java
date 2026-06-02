class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int n = landStartTime.length;
        int m = waterStartTime.length;
        int landMini = Integer.MAX_VALUE;
        int waterMini = Integer.MAX_VALUE;
        int land_Water = Integer.MAX_VALUE;
        int water_Land = Integer.MAX_VALUE;


        // land + water
        for(int i = 0; i < n; i++) {
            int mini = landStartTime[i] + landDuration[i];
            landMini = Math.min(mini, landMini);
        }



        // water + land
        for(int i = 0; i < m; i++) {
        int miniWater = waterStartTime[i] + waterDuration[i];
        waterMini = Math.min(miniWater, waterMini);
        land_Water = Math.min(land_Water, Math.max(waterStartTime[i], landMini) + waterDuration[i]);     
    }
    

    for(int i = 0; i < n; i++) {
        water_Land = Math.min(water_Land, Math.max(landStartTime[i], waterMini) + landDuration[i]);
    }

    return Math.min(water_Land, land_Water);
 }

}