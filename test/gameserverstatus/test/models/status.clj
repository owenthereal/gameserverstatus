(ns gameserverstatus.test.models.status
  (:use [gameserverstatus.models.status])
  (:use [clojure.test]))

(deftest test-hyphenate
         (testing "with upper case"
                  (is (= "foo-bar" (hyphenate "FOO BAR"))))
         (testing "with different separators"
                  (is (= "foo-bar" (hyphenate "foo bar")))
                  (is (= "foo-bar" (hyphenate "foo-bar")))
                  (is (= "foo-bar" (hyphenate "foo_bar"))))
         (testing "with extra space"
                  (is (= "foo-bar" (hyphenate "foo bar  ")))
                  (is (= "foo-bar" (hyphenate "   foo bar")))
                  (is (= "foo-bar" (hyphenate "foo   bar")))))
