package org.leetcode.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>(nums.length,1.0f);
		int result[] = new int[2];
		map.put(nums[0], 0);
		for(int i=0;i<nums.length;i++){
			int value = target-nums[i];
			if(map.containsKey(value)){
				result[0] = (int)map.get(value);
				result[1] = i;
				return result;
			}else{
				map.put(nums[i], i);
			}
		}
		return result;
	}
}
