;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns cljs.server.rhino
  (:require [cljs.repl :as repl]
            [cljs.repl.rhino :as rhino]
            [cljs.core.server :as server]))

(defn repl [{:keys [opts env-opts]}]
  (repl/repl* (rhino/repl-env* env-opts) opts))

(defn prepl [{:keys [opts env-opts]}]
  (apply server/io-prepl
    (mapcat identity
      (merge {:repl-env (rhino/repl-env* env-opts)} opts))))
