# Fabric8 client testing


[DOM-22611](https://dominodatalab.atlassian.net/browse/DOM-22611) for details.

## Usage

Build:

```
$ docker build -t quay.io/domino/fabric8-client-test .
```

Run:

```
$ kubectl apply -f - <<EOF
kind: ClusterRoleBinding
apiVersion: rbac.authorization.k8s.io/v1
metadata:
  name: default-cluster-admin-temporary
roleRef:
  apiGroup: rbac.authorization.k8s.io
  kind: ClusterRole
  name: cluster-admin
subjects:
- kind: ServiceAccount
  name: default
  namespace: default
EOF
$ kubectl run --attach --rm --image=quay.io/domino/fabric8-client-test --restart=Never fabric8-client-test
$ kubectl delete clusterrolebinding default-cluster-admin-temporary
```
