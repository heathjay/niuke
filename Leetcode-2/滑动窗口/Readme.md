void window(string s, string t) {
    unordered_map<char, int> window, target;
    for (char c : t) { ++target[c]; }
    int left = 0, right = 0;    // 初始化双指针
    ...                         // 定义状态值
    while (right < s.size()) {
        // 增大窗口
        char c = s[righ]
        ++right;
        ...                     // 更新window
        while (达到缩小窗口的条件) {
            ...                 // 更新状态值
            char c = s[left];
            ++left;
            ...                 // 更新window/状态值
        }
    }
}